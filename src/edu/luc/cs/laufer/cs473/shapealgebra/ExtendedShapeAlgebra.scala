package edu.luc.cs.laufer.cs473.shapealgebra

/**
 * The category of shape algebras extended to support additional shapes.
 */
trait ExtendedShapeAlgebra[R] extends ShapeAlgebra[R] {

  def visitStroke(r: R, s: Stroke): R
  def visitFill(s: Shape): R
  def visitOutline(s: Shape): R
  def visitPoint(p: Point): R
  def visitPolygon(ps: Seq[R], p:Polygon): R
  def visitRotate(r: Rotate): R
  def visitCircle(c: Circle): R

  // TODO: add missing visit methods similarly to Location

  /**
   * The extended catamorphism for shapes.
   */
  override def fold(s: Shape): R = s match {
    case s: Stroke => visitStroke(fold(s.shape), s)
    case f: Fill => visitFill(f)
    case o: Outline => visitOutline(o)
    case p: Point => visitPoint(p)
    case p: Polygon => visitPolygon(p.points.map(fold(_)), p)
    case r: Rotate => visitRotate(r)
    case c: Circle => visitCircle(c)
    // TODO: add missing cases similarly to Location
    case _ => super.fold(s)
  }
}
