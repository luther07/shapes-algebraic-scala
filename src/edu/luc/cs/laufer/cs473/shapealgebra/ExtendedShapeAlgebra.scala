package edu.luc.cs.laufer.cs473.shapealgebra

/**
 * The category of shape algebras extended to support additional shapes.
 */
trait ExtendedShapeAlgebra[R] extends ShapeAlgebra[R] {

  def visitStroke(r: R, s: Stroke): R
  def visitFill(r: R, f: Fill): R
  def visitOutline(r: R, o:Outline ): R
//def visitPoint(p: Point): R
  def visitPolygon(p:Polygon): R
  def visitRotate(r: R, rot: Rotate): R
  def visitCircle(c: Circle): R

  // TODO: add missing visit methods similarly to Location

  /**
   * The extended catamorphism for shapes.
   */
  override def fold(s: Shape): R = s match {
    case s: Stroke => visitStroke(fold(s.shape), s)
    case f: Fill => visitFill(fold(f.shape), f)
    case o: Outline => visitOutline(fold(o.shape), o)
//  case p: Point => visitPoint(p)
    case p: Polygon => visitPolygon(p)
    case rot: Rotate => visitRotate(fold(rot.shape), rot)
    case c: Circle => visitCircle(c)
    // TODO: add missing cases similarly to Location
    case _ => super.fold(s)
  }
}
