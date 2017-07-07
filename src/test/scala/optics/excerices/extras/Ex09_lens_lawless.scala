package optics.excerices.extras

import optics.classic.Lens
import org.specs2.Specification

class LensLawlessSpec extends Specification {

  def is =
    s2"""
    Lens should fulfill three laws:
     - setting a field and than getting it back should return originally set field value
     - getting a field and then setting it back should return  the same field value
     - setting a field twice is the same as setting it once with last value. Last one wins

    Write a lens which validates above laws and a proof that the laws are validated.
      $setting
      $getting
      $settingTwice
    """


  def setting = ko("implement me")

  def getting = ko("implement me")

  def settingTwice = ko("implement me")

}
