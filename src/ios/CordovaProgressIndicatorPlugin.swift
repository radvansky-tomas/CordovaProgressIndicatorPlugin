import UIKit
import SVProgressHUD

@objc(CordovaProgressIndicatorPlugin) class ModusEchoSwift : CDVPlugin {
    @objc(show:)
    func show(command: CDVInvokedUrlCommand) {
        let pluginResult = CDVPluginResult(
            status: CDVCommandStatus_OK
        )
        //Disable interaction
        SVProgressHUD.setDefaultMaskType(.black)

        let msg = command.arguments[0] as? String ?? ""

        if msg.characters.count == 0{
            SVProgressHUD.show()

        }
        else
        {
            SVProgressHUD.show(withStatus: msg)
        }

        self.commandDelegate!.send(
            pluginResult,
            callbackId: command.callbackId
        )
    }

    @objc(hide:)
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

      @objc(isShown:)
        func isShown(command: CDVInvokedUrlCommand) {
            self.commandDelegate!.send(
                CDVPluginResult.init(status: CDVCommandStatus_OK, messageAs: SVProgressHUD.isVisible()),
                callbackId: command.callbackId
            )
        }

}