/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.lastweetfm.web

import javax.annotation.ManagedBean;
import org.springframework.context.annotation.Scope;
import javax.faces.context.FacesContext
import scala.reflect.BeanProperty

@ManagedBean
@Scope("session")
@serializable
class PreferencesBean {
  @BeanProperty
  var currentLocale = FacesContext.getCurrentInstance.getApplication.getDefaultLocale()
  @BeanProperty
  var menuPosition = "left"
  @BeanProperty
  var currentColor = "gray"
}
