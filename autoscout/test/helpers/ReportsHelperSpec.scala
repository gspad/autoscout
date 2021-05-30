package helpers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import scala.io.Source

class ReportsHelperSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {
  "ReportsHelper getIndexesFor" should {

    "return an array with the column indexes for the specified column name" in {
      val helper = new ReportsHelper();
      val source = Source.fromString("\"id\",\"make\",\"price\",\"mileage\",\"seller_type\"");
      val index_arr = helper.getIndexesFor(source,"make","id","seller_type");
      index_arr(0) mustBe 1;
      index_arr(1) mustBe 0;
      index_arr(2) mustBe 4;
    }

  }
}