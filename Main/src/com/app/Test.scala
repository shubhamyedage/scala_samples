package com.app

import javax.crypto.spec.SecretKeySpec
import javax.crypto.Mac;
import java.nio.charset.StandardCharsets;
/**
  * Created by synerzip on 13/4/17.
  */
class Test {
  def main(args: Array[String]) {

  }

  def getNonce(): String = {
    val input = ("").getBytes(StandardCharsets.UTF_8);
    return Base64.encodeBase64String(input);
  }

  def getAuthToken(nonce: String , privateKey: String):String ={
    val key = new SecretKeySpec(privateKey.getBytes("UTF-8"), "");
    val mac = Mac.getInstance("");
    mac.init(key);

    val bytes = mac.doFinal(nonce.getBytes("ASCII"));
    return Base64.encodeBase64String(bytes);
  }
}
