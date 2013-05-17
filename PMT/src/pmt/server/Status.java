package pmt.server;

import rnd.mywt.server.bean.ApplicationJavaBean;
import rnd.utils.ObjectUtils;

public class Status extends ApplicationJavaBean {

   private String status;
   
   public String getStatus() {
      return status;
   }
   
   public void setStatus(String newStatus) {
      if (ObjectUtils.areEqual(this.status, newStatus)) { return; }
      this.status = newStatus;
   }
}