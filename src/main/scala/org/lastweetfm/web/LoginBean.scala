/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lastweetfm.web

import javax.annotation.ManagedBean
import org.springframework.context.annotation.Scope
import scala.reflect.BeanProperty
import javax.inject.Named
import org.springframework.security.authentication.{UsernamePasswordAuthenticationToken, AuthenticationManager}
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.AuthenticationException

@ManagedBean
@Scope("request")
class LoginBean(@Named("authenticationManager") val am: AuthenticationManager) {

  @BeanProperty
  var userName: String = _
  @BeanProperty
  var password: String = _
  
  def login() = {
    try {
      val result = am.authenticate(
            new UsernamePasswordAuthenticationToken(userName, password))
      
      SecurityContextHolder.getContext.setAuthentication(result)
      "login"

    } catch {
      case e: AuthenticationException =>
        val m = FacesUtils.bundleKey("msg", "login.failed")
        FacesUtils.addErrorMessage(m)
        null
    }
  }
}
