/**
 * TermDbManageHandler.java
 *
 * Version information :
 *
 * Date:2012-5-3
 *
 * Copyright notice :
 * 本文件及其附带的相关文件包含机密信息，仅限瀚特盛科技有限公司指定的，与本项目有关的内部人员和客户联络人员查阅和使用。 
 * 如果您不是本保密声明中指定的收件者，请立即销毁本文件，禁止对本文件或根据本文件中的内容采取任何其他行动， 
 * 包括但不限于：泄露本文件中的信息、以任何方式制作本文件全部或部分内容之副本、将本文件或其相关副本提供给任何其他人。
 */
package net.heartsome.cat.database.ui.tb.handler;

import net.heartsome.cat.database.ui.tb.dialog.TermDbManagerDialog;
import net.heartsome.cat.ts.help.SystemResourceUtil;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.slf4j.LoggerFactory;



/**
 * @author  jason
 * @version 
 * @since   JDK1.6
 */
public class TermDbManageHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		String tshelp = System.getProperties().getProperty("TSHelp");
		String tsstate = System.getProperties().getProperty("TSState");
		if (tshelp == null || !"true".equals(tshelp) || tsstate == null || !"true".equals(tsstate)) {
			LoggerFactory.getLogger(TermDbManageHandler.class).error("Exception:key hs008 is lost.(Can't find the key)");
			System.exit(0);
		}
		SystemResourceUtil.load();
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		TermDbManagerDialog dialog = new TermDbManagerDialog(window.getShell());
		dialog.setDialogUseFor(TermDbManagerDialog.TYPE_DBMANAGE);
		dialog.open();
		return null;
	}

}
