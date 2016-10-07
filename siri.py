import web
from search import getresults
import json
urls=('/.*','siri')

app=web.application(urls,globals(),True)
render=web.template.render('templates/')
class siri :
    def GET(self):
        return render.home('&#',3203) 
    def POST(self):
        print 'received'
        data=web.input()
        results=getresults(data.query)
        return render.results(json.dumps(results))
if __name__=='__main__':
    app.run()


