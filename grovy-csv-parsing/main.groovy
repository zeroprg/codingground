/* Hello World in Groovy */
println("Script started ")

def parseCsvTo(filename) {
	 try
	 {
	 //  sql = Sql.newInstance(dbArg, dbUser,dbPassword, dbDriver)
     //	 def event_log = sql.dataSet("EVENT_LOG")
       println filename
	   File newfile = new File(filename)
	   println "newfile: " + newfile
	   newfile.eachLine { line, number -> 
	     println filename + ", number: " + number
	     line.splitEachLine(",")  { items ->

		     println  "GPS_LON:"  +  items[1] + " GPS_LAT:" + items[2] +  " SPEED:" + items[4] +   " BEARING:"+ items[5]
	     }
	   }
      }
	 finally 
	 {
	     println "parsing " + filename + " completed. "
	 }
 }
 
def regexStr = /.csv/
def folder = /test/
new File(folder).eachFile() 
  { file->  
    
    def fileName = file.getName()
    //println fileName
    def finder = (fileName =~ regexStr)
    if ( finder )
    {
       println "File " + fileName + " founded and processing ...."   
       parseCsvTo(folder + "/" + fileName)
    } 
}  


println("Script finished ")
