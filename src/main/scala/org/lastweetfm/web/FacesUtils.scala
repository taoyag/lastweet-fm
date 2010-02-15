package org.lastweetfm.web

import javax.faces.context.FacesContext
import javax.faces.application.FacesMessage

/**
 * @author taoyag
 * Date: 2010/02/14 21:52:50
 */

object FacesUtils {
  
  def bundleKey(bundleName: String, key: String) = {
    facesContext.
            getApplication.
            getResourceBundle(facesContext, bundleName).
            getString(key)
  }

  def addSuccessMessage(msg: String) {
    addMessage(FacesMessage.SEVERITY_INFO, msg)
  }

  def addErrorMessage(msg: String) {
    addMessage(FacesMessage.SEVERITY_ERROR, msg)
  }

  def addMessage(severity: FacesMessage.Severity, msg: String) {
    val m = new FacesMessage(severity, msg, msg)
    facesContext.addMessage(null, m)
  }

  def facesContext = FacesContext.getCurrentInstance
}