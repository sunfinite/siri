#!/bin/env python
#Filename: search.py

import sqlite3
import codecs



def getresults(query) :
	conn=sqlite3.connect("search")
	cur=conn.cursor()
	query=query.strip()
	words=query.split()
	urls=[]
	idf=[]
	display={}
	results=[]
	fragment=[]
	for word in words :
		cur.execute("select u.url,f.frequency,u.title,u.rowid from freqtable f,wordtable w,urltable u where w.word=? and w.rowid=f.wordid and f.urlid=u.rowid ",[word])
		rows=cur.fetchall()
		rows=[list(item) for item in rows]
		cur.execute("select idf from wordtable where word=?",[word])
		rows1=cur.fetchone()
		for row in rows:
			row[1]*=rows1[0] #tf*idf
		results.append(rows)
	
	for index,result in enumerate(results):
		for url in result:
			f=codecs.open(url[0],'r','UTF-8')
			string=f.read()
			fragments=string.split()
			if not display.has_key(url[0]) :
				temp={}
				temp['url']=url[0][8:]
				
				if(url[2]==''):
					while(len(url[2])<=42 and url[0]!=''):
						url[2]=url[0].split('/')[-1]+url[2]
						url[0]='/'.join(url[0].split('/')[:-1])
				if(len(url[2])>50):
					url[2]=url[2][:50]+'...'
				temp['title']=url[2]
				temp['tf-idf']=url[1]
				temp['matches']=1
				try:
					ind=fragments.index(words[index])
					if ind<3 :
						fragment=fragments[:ind]+['<b>',words[index],'</b>']+fragments[ind+1:15]
					elif ind>len(fragments)-5 :
						fragment=fragments[ind-15:ind]+['<b>',words[index],'</b>']+fragments[ind+1:]
					else :
						fragment=fragments[ind-8:ind]+['<b>',words[index],'</b>']+fragments[ind+1:ind+8]

					temp['snippet']=' '.join(fragment)
				except : temp['snippet']=''
				display[url[0]]=temp
			else :
				display[url[0]]['tf-idf']+=url[1]
				display[url[0]]['matches']+=1
				try:
					ind=fragment.index(words[index])
					if ind :
						fragment=fragment[:ind]+['<b>',words[index],'</b>']+fragment[ind+1:]
						display[url[0]]['snippet']=' '.join(fragment)				
				except : pass					

	finallist=display.values()
	finallist.sort(key=lambda k:k['tf-idf'],reverse=True)	
	return finallist 

if __name__=='__main__':
	getquery=codecs.open('tempread','r','UTF-8')
	query=getquery.read()
	results=getresults(query)
	results=results[:2]
	for result in results: 
		print result['url']
		print result['title']
