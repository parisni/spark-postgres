package meta

import fr.aphp.wind.eds.omop.orbis.SparkSessionTestWrapper
import meta.ConfigMetaYaml.Database
import net.jcazevedo.moultingyaml._
import org.apache.spark.sql.QueryTest

import scala.io.Source

class ConfigTest extends QueryTest
  with SparkSessionTestWrapper
  with FeatureExtract {


  test("test fhir patient") {
    val filename = getClass.getResource("/meta/config.yaml").getPath
    val ymlTxt = Source.fromFile(filename).mkString
    val yaml = ymlTxt.stripMargin.parseYaml
    val palette = yaml.convertTo[Database]

    for(pal <- palette.schemas.getOrElse(Nil)){
      println(pal.dbName)

    }

    println(palette.toYaml.prettyPrint)
  }
}


