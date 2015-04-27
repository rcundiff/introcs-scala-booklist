import scala.collection.mutable.ListBuffer
import scala.util.Try
import scala.io.Source


case class Book(title : String, author : String, year : Int)

class BookList {
   var list = ListBuffer[Book]()

   def addBook(book : Book) : Unit = {
     list += book
   }

   def getNumberOfBooks() : Int = list.length
      

   def printList() : Unit = {
      // write code to printList()
      // you should also show how to use the method in your main
   }

   def getTitlesByAuthor(author : String) : ListBuffer[String] = {
      val byAuthorList = ListBuffer[String]()
      // return a list of all titles that are written by author

      for (i <- list) {
          
          if (i.author = author) {
                byAuthorList += i.title
          }
          
          
      }
       
      byAuthorList
   }

   def getTitlesContaining(substring : String) : ListBuffer[String] = {
      val titles = ListBuffer[String]()
      // return a list of all titles that contain a substring

      for (i <- list) {
          
          titles += i.title
          
      } 
       
      titles
   }

   def getBooksBetweenYears(firstYear : Int, lastYear : Int) : ListBuffer[Book] = {
     
      val betweenYearList = ListBuffer[Book]()
      // get all books between two years

        for (i <- list) {
         
            
            
            
            
        }
       

      betweenYearList
   }

   def addFromFile(name : String) : Unit = {
     // instructor did this one for you...mostly
     for (file <- Try(Source.fromFile(name))) {
        for (line <- file.getLines) {
           val parts = line.split(":")
           if (parts.length >= 3) {
              val title = parts(0)
              val author = parts(1)
              val year = Try(parts(2).toInt).getOrElse(0)
              list += Book(title, author, year)
           } else {
              println("Ignoring: " + line)
           }
        } 
     } 
   }

   def addAll(books : BookList) : Unit = {
      // instructor did this one for you, too
      books.list foreach { n => list += n }
   }
}
