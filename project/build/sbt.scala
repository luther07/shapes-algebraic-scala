import sbt._
class ShapesAlgebraicScala(info: ProjectInfo) extends DefaultProject(info) {
  
   val junit = "junit" % "junit" % "4.6"

   val scalaSwing = "org.scala-lang" % "scala-swing" % "2.9.1"
  
   override def mainScalaSourcePath = "src" / "edu" / "luc" / "cs" / "laufer" / "cs473" / "shapealgebra"
  
   override def mainResourcesPath = "resources"
  
   override def testScalaSourcePath = "test" / "edu" / "luc" / "cs" / "laufer" / "cs473" / "shapealgebra"
  
   override def testResourcesPath = "test-resources"
  
}
