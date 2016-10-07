#!/usr/bin/python
#Filename:check.py

from __future__ import division
from BeautifulSoup import BeautifulSoup
import codecs
from strip import gettext
import HTMLParser
import os


#Function for cases where the punctuations and the words are not separated by spaces.
def checkpunct(string):
 if(len(string)!=0):
        j=-1#for punctuations at the end of the word...eg:what????
        temp=string[j]
        while(not(repr(temp)>="u'\u0c82'" and repr(temp)<="u'\u0cef'")):
                j-=1
		if(j==-(len(string)+1)):
			return	
                temp=string[j]
        j+=1#slicing does not include the last character 
        k=0
        temp=string[k]
        while(not(repr(temp)>="u'\u0c82'" and repr(temp)<="u'\u0cef'") ): #for punctuations at the beginning ....kindalikethis       
                k+=1
                temp=string[k]
        if(j==0):
                string=string[k:]#Slicing out the punctuation marks
        else:
                string=string[k:j]
	

        j=0 
        temp=string[j]#But,punctuations can be in the middle without spaces,can't they?
        while(repr(temp)>="u'\u0c82'" and repr(temp)<="u'\u0cef'"):
            j+=1#Keep going till you find the first punctuation
            if(j==len(string)):
                break 
            temp=string[j]
        str1=string[:j] #Slice till the first punctuation
        wordfrequency(str1) #Put the first slice in the dictionary
        str2=string[(j+1):]#The second slice may still contain punctuations Eg:F.R.I.E.N.D.S.
        checkpunct(str2)#Recursively call for the second slice

#Function to build dictionary 
def wordfrequency(temp):
	global fullstring
	fullstring+=temp+" "

def indexer(indexfile) :
	global fullstring
	global wordlist
	global flag
	global proceed
	if not os.path.isdir(indexfile) :
		print indexfile
		wordcount=0	
		fullstring=""
		h=HTMLParser.HTMLParser()
		soup=BeautifulSoup(file(indexfile))			
		string=gettext(soup) #function defined in the strip module.
		string=h.unescape(string)#Convert all HTML entities to Unicode.
		words=string.split()
		for word in words:
			for char in word:
				#proceed with the word if it contains atleast one kannada character
				if(repr(char)>="u'\u0c82'" and repr(char)<="u'\u0cef'"):
					proceed=True
			if proceed==True:
				proceed=False
				if(not word.isalnum() and len(word)>1):
					for char in word:
						if((not(repr(char)>="u'\u0c82'" and repr(char)<="u'\u0cef'")) and (not char.isalnum())):
							flag=True
					if flag==True:
						checkpunct(word)
						flag=False
					else:
						wordfrequency(word)
				else:
					wordfrequency(word)	
		f=codecs.open(indexfile,"w","UTF-8")
		f.write(fullstring)
	else :
		dirlist=os.listdir(indexfile)
		for item in dirlist :
			indexable=os.path.join(indexfile,item)
			indexer(indexable)


flag=False
proceed=False
fullstring=""
indexer('check.html')
