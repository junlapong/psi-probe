/*
 * Licensed under the GPL License. You may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * THIS PACKAGE IS PROVIDED "AS IS" AND WITHOUT ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * WITHOUT LIMITATION, THE IMPLIED WARRANTIES OF MERCHANTIBILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE.
 */

package psiprobe.controllers.jsp;

import org.apache.catalina.Context;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import psiprobe.controllers.ContextHandlerController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The Class DiscardCompiledJspController.
 *
 * @author Vlad Ilyushchenko
 */
public class DiscardCompiledJspController extends ContextHandlerController {

  @Override
  protected ModelAndView handleContext(String contextName, Context context,
      HttpServletRequest request, HttpServletResponse response) throws Exception {

    getContainerWrapper().getTomcatContainer().discardWorkDir(context);
    return new ModelAndView(new RedirectView(request.getContextPath() + getViewName() + "?"
        + request.getQueryString()));
  }

}
