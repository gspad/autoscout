import scala.collection.{mutable}
import scala.collection.mutable.HashMap
import scala.io.Source
import helpers.ReportsHelper


class ReportsModel
{
  private val seller_type_to_price_map = new mutable.HashMap[String, Int]();
  private val num_listings_per_seller_type = new mutable.HashMap[String, Int];

  def processAvgBySellerType(source: Source): mutable.HashMap[String,Int] =
  {
    //TODO put the averages in the map for each seller_type
    return null;
  }

  private[this] def processAvgBySellerTypeHelper(source: Source)
  {
    val helper = new ReportsHelper();
    var col_indexes = helper.getIndexesFor(source, "price","seller_type");


    for (line <- source.getLines().drop(1)) {
      val seller_type = line.split(",")(col_indexes(1));
      val price : Int = line.split(",")(col_indexes(0)).toInt;

      if(!seller_type_to_price_map.contains(seller_type))
        {
          seller_type_to_price_map.put(seller_type, 0)
          num_listings_per_seller_type.put(seller_type,0);
        }

      seller_type_to_price_map(seller_type) += price;
      num_listings_per_seller_type(seller_type) += 1;
    }
    source.close
  }
}