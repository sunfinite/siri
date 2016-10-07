#!/usr/bin/env python
#Filename:similar.py

import sqlite3
import re
import codecs

conn=sqlite3.connect("search")
cur=conn.cursor()
cur.execute("select word from wordtable")
row=cur.fetchall()
words=[]
similar=[]
for item in row:
	words.append(item[0])

string='\n'.join(word for word in words)

words1=words[2934:10001]

for word in words1:
	results=[]
	if len(word)>1:
		print words.index(word)
		var=word
		var1=var
		while(not var1[-1].isalnum()):
			var1=var1[:-1]
		test='\n'+var+'.*'
		results+=re.findall(test,string)
		results=[result.strip() for result in results]


		test='\n'+var1+'.*'
		results+=re.findall(test,string)
		results=[result.strip() for result in results]

		test='.*'+var+'.*'
		results+=re.findall(test,string)

		test='.*'+var1+'.*'
		results+=re.findall(test,string)

		unique={}
		for result in results :
			if not unique.has_key(result) and result!=word:
				unique[result]=1
				s=set([ words.index(word)+1,words.index(result)+1 ])#rowid starts from 1 in sqlite
				try :
					similar.index(s)
				except:
					similar.append(s)
					e1,e2=s
					cur.execute("insert into simtable values (?,?)",[e1,e2])
													
					conn.commit()

		
