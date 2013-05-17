package pmt.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

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