package edu.luc.cs.laufer.cs473.shapealgebra

object ExtendedShapeSize extends ExtendedShapeAlgebra[Int] {
  // forward methods for original shapes at object level
  override def visitEllipse(e: Ellipse) = ShapeSize.visitEllipse(e)
  override def visitRectangle(r: Rectangle) = ShapeSize.visitRectangle(r)
  override def visitLocation(l: Location) = ShapeSize.visitLocation(r: Int, l)
  override def visitGroup(g: Group) = ShapeSize.visitGroup(Seq[Int], g)
  // TODO: methods for the other original shapes
  // new methods for extended shapes
  override def visitStroke(r: Int, s: Stroke) = r
  override def visitFill(r: Int, f: Fill ) = r
  override def visitOutline(r: Int, o: Outline) = r
  override def visitPoint(p: Point) = 1
  override def visitPolygon(p: Polygon) = 1
  override def visitRotate(r: Int, rot: Rotate) = r
  override def visitCircle(c: Circle) = 1
  // TODO: methods for the other additional (extended) shapes
}

object ExtendedShapeDepth extends ExtendedShapeAlgebra[Int] {
  //override def visitEllipse(e: Ellipse) = 
  // TODO: all methods defined from scratch
}

class ExtendedBoundingBox extends BoundingBox with ExtendedShapeAlgebra[Location] {
  // methods for original shapes inherited at class level
  // TODO: methods for the other additional (extended) shapes
  override def visitStroke(r: Location, s: Stroke) = r
  // TODO: reduce Circle to Ellipse (avoid code duplication)
  // etc.
}

object ExtendedBoundingBox extends ExtendedBoundingBox
