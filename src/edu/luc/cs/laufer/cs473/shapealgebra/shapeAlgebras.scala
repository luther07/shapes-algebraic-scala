package edu.luc.cs.laufer.cs473.shapealgebra

object ShapeSize extends ShapeAlgebra[Int] {
  override def visitEllipse(e: Ellipse) = 1
  override def visitRectangle(r: Rectangle) = 1
  override def visitLocation(r: Int, l: Location) = r
  override def visitGroup(rs: Seq[Int], g: Group) = rs.sum
}

class BoundingBox extends ShapeAlgebra[Location] {
  override def visitEllipse(e: Ellipse) =
    Location(-e.halfWidth, -e.halfHeight, Rectangle(2 * e.halfWidth, 2 * e.halfHeight))
  override def visitRectangle(r: Rectangle) =
    Location(0, 0, r)
  override def visitLocation(b: Location, l: Location) = {
    Location(l.x + b.x, l.y + b.y, b.shape)
  }
  override def visitGroup(rs: Seq[Location], g: Group) = {
    val result = rs.reduceLeft((a: Location, b: Location) => {
      val minx = (a.x).min(b.x)
      val miny = (a.y).min(b.y)
      val rectWidth = ((a.x + a.shape.asInstanceOf[Rectangle].width).max(b.x + b.shape.asInstanceOf[Rectangle].width)+(-minx))
      val rectHeight = ((a.y + a.shape.asInstanceOf[Rectangle].height).max(b.y + b.shape.asInstanceOf[Rectangle].height)+(-miny))
      Location(minx, miny, Rectangle(rectWidth, rectHeight))
    }) 
    result


  }
}

object BoundingBox extends BoundingBox
