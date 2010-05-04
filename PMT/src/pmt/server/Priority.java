package pmt.server;

import rnd.mywt.client.utils.ObjectUtils;
import rnd.mywt.server.bean.ApplicationJavaBean;

public class Priority extends ApplicationJavaBean {

   private String priority;
   
   public String getPriority() {
      return priority;
   }
   
   public void setPriority(String newPriority) {
      if (ObjectUtils.areEqual(this.priority, newPriority)) { return; }
      this.priority = newPriority;
   }
}