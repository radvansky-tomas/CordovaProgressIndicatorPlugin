import UIKit
import SVProgressHUD

@objc(CordovaProgressIndicatorPlugin) class CordovaProgressIndicatorPlugin : CDVPlugin {
    func show(command: CDVInvokedUrlCommand) {
        let pluginResult = CDVPluginResult(
            status: CDVCommandStatus_OK
        )
        let message:NSString = command.argument(at: 0, withDefault: "", andClass: NSString.self) as! NSString
        if message.length == 0{
            SVProgressHUD.show()
        }
        else
        {
            SVProgressHUD.show(withStatus: message as String!)
        }

        self.commandDelegate!.send(
            pluginResult,
            callbackId: command.callbackId
        )
    }

    func hide(command: CDVInvokedUrlCommand) {
        let pluginResult = CDVPluginResult(
            status: CDVCommandStatus_OK
        )

        SVProgressHUD.dismiss()

        self.commandDelegate!.send(
            pluginResult,
            callbackId: command.callbackId
        )
    }
}