package edu.luc.cs.laufer.cs473.shapealgebra

object ExtendedShapeSize extends ExtendedShapeAlgebra[Int] {
  // forward methods for original shapes at object level
  override def visitEllipse(e: Ellipse) = ShapeSize.visitEllipse(e)
  override def visitRectangle(r: Rectangle) = ShapeSize.visitRectangle(r)
  override def visitLocation(r: Int, l: Location) = ShapeSize.visitLocation(r: Int, l)
  override def visitGroup(rs: Seq[Int], g: Group) = ShapeSize.visitGroup(rs: Seq[Int], g)
  // TODO: methods for the other original shapes
  // new methods for extended shapes
  override def visitStroke(r: Int, s: Stroke) = r
  override def visitFill(r: Int, f: Fill) = r
  override def visitOutline(r: Int, o: Outline) = r
  override def visitPoint(p: Point) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitRotate(r: Int, rot: Rotate) = r
  override def visitCircle(c: Circle) = 1
  // TODO: methods for the other additional (extended) shapes
}

object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  override def visitEllipse(e: Ellipse) = 0 		//logic not worked out
  override def visitRectangle(r: Rectangle) = 0 	//logic not worked out
  override def visitLocation(r: Int, l: Location) = 0 	//logic not worked out
  override def visitGroup(rs: Seq[Int], g: Group) = 0 	//logic not worked out
  override def visitStroke(r: Int, f: Fill) = 0  	//logic not worked out
  override def visitFill(r: Int, f: Fill) = 0 		//logic not worked out
  override def visitOutline(r: Int, o: Outline) = 0 	//logic not worked out
  override def visitPolygon(p: Polygon) = 0 		//logic not worked out
  override def visitRotate(r: Int, rot: Rotate) = 0 	//logic not worked out
  override def visitCircle(c: Circle) = 0 		//logic not worked out
  // TODO: all methods defined from scratch
}

class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(s: Stroke) = 
  override def visitFill(r: Location, f: Fill) = 
  override def visitOutline(r: Location, f: Fill) = r
  override def visitPolygon(p: Polygon) = {
    result = p.points.reduceLeft(((a: Point, b: Point) => {
      val minx = (a.x).min(b.x))
      val miny = (a.y).min(b.y))
      val maxx = (a.x).max(b.x))
      val maxy = (a.y).max(b.y))
      val rectWidth = maxx + (-minx)
      val rectHeight = maxy = (-miny)
      Location(minx, miny, Rectangle(rectWidth, rectHeight))
    } 
    result
  }
  override def visitRotate(r: Location, rot: Rotate) = r
  override def visitCircle(c: Circle) = Location(-r, -r, Rectangle(2*r, 2*r))
    
  // TODO: reduce Circle to Ellipse (avoid code duplication)
  // etc.
}

object ExtendedBoundingBox extends ExtendedBoundingBox
