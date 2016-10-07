#!/usr/bin/env python
#Filename:findsimilar.py


import sqlite3
import codecs
import re

conn=sqlite3.connect("search")
cur=conn.cursor()
fin=codecs.open("tempread","r","UTF-8")
fout=codecs.open("temp.txt","w","UTF-8")
word=fin.read()
word=word.strip()
fout.write("The queried word is : "+word+'\n')
words=[]
results=[]
cur.execute("select word from wordtable where rowid in (select s.wordid2 from simtable s ,wordtable w  where s.wordid1=w.rowid and w.word=?)",[word])
row=cur.fetchall()
cur.execute("select word from wordtable where rowid in (select s.wordid1 from simtable s ,wordtable w  where s.wordid2=w.rowid and w.word=?)",[word])
row1=cur.fetchall()
row+=row1
for item in row:
	if(len(item[0])==2 and not item[0][-1].isalnum()):
		pass
	else :
		words.append(item[0])	
string='\n'.join(word for word in words)
var=word
var1=var
test='\n'+var+'.*'
results+=re.findall(test,string)
results=[result.strip() for result in results]
while(not var1[-1].isalnum()):
	var1=var1[:-1]
test='\n'+var1+'.*'
results+=re.findall(test,string)
results=[result.strip() for result in results]

test='.*'+var+'.*'
results+=re.findall(test,string)

test='.*'+var1+'.*'
results+=re.findall(test,string)

if not results:
	results=words
unique={}
fout.write("Similar words(hopefully) :\n")
for result in results:
	if not unique.has_key(result) :
		unique[result]=1
		fout.write(result+'\n')
