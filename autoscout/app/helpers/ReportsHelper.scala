package helpers

import scala.util.control.Breaks._
import scala.io.Source



class ReportsHelper
{
  def getIndexesFor(source: Source, col_names: String*): Array[Int] = {
    val arr_size = col_names.size;
    val result = new Array[Int](arr_size);
    val columns_from_csv = source.getLines().take(1).mkString.replaceAll("\"","").split(",");
    var arr_index = 0;
    var iterator = 0;

    col_names.foreach(col_name => {
      iterator = 0;
      columns_from_csv.foreach(col =>
      {
        if(col.equals(col_name))
        {
          result(arr_index) = iterator;
          arr_index += 1;
        }
        iterator += 1;
      })
    })
    return result;
}
}