package meta

import fr.aphp.wind.eds.omop.orbis.SparkSessionTestWrapper
import org.apache.spark.sql.QueryTest

class MetaSyncTest extends QueryTest
  with SparkSessionTestWrapper
  with FeatureExtract {


  test("test loading postgres") {

    val yaml = getClass.getResource("/meta/config.yaml").getPath
    println(yaml)

   // MetaSync.run(spark, yaml)
  }
}


