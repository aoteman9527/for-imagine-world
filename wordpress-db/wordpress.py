#!/usr/bin/python
# -*- coding: utf-8 -*-
import MySQLdb


db = MySQLdb.connect(host="127.0.0.1", # your host, usually localhost
                     user="letuan", # your username
                      passwd="sieunhan", # your password
                      db="wordpress", # name of the data base
                      charset="utf8", 
                      use_unicode=False) 

# you must create a Cursor object. It will let
#  you execute all the queries you need
cur = db.cursor() 

# Use all the SQL you like
cur.execute("select count(*) from wp_term_relationships where term_taxonomy_id=1");


# print all the first cell of all the rows
for row in cur.fetchall() :
    print row[0]


var1 = 'Hello World!'
var2 = "Python Programming"

print "var1[0]: ", var1[0]
print "var2[1:5]: ", var2[1:5]

title = '[TRUYEN][Tháp Kỳ][Tháp Kỳ > Chương 74]'
first = str.index(title,'][')+2
second = str.index(title,'][',first)
print title[first:second]
print '========================================================'
cur.execute('select post_title from wp_posts order by post_title')
lastCategory=''
for row in cur.fetchall() :
  title=row[0]
  try:
   first = str.index(title,'][')+2
   second = str.index(title,'][',first)
   if lastCategory != title[first:second] :
     print title[first:second]
     lastCategory = title[first:second]
  except ValueError:
   print 'ERROR',title
  

db.close()
