import java.util.*;
import com.systemj.ClockDomain;
import com.systemj.Signal;
import com.systemj.input_Channel;
import com.systemj.output_Channel;

public class Controller extends ClockDomain{
  public Controller(String name){super(name);}
  Vector currsigs = new Vector();
  private boolean df = false;
  private char [] active;
  private char [] paused;
  private char [] suspended;
  public Signal pusherRetracted = new Signal("pusherRetracted", Signal.INPUT);
  public Signal pusherExtended = new Signal("pusherExtended", Signal.INPUT);
  public Signal WPgripped = new Signal("WPgripped", Signal.INPUT);
  public Signal armAtSource = new Signal("armAtSource", Signal.INPUT);
  public Signal armAtDest = new Signal("armAtDest", Signal.INPUT);
  public Signal empty = new Signal("empty", Signal.INPUT);
  public Signal request = new Signal("request", Signal.INPUT);
  public Signal mode = new Signal("mode", Signal.INPUT);
  public Signal pusherExtendM = new Signal("pusherExtendM", Signal.INPUT);
  public Signal vacOnM = new Signal("vacOnM", Signal.INPUT);
  public Signal armSourceM = new Signal("armSourceM", Signal.INPUT);
  public Signal armDestM = new Signal("armDestM", Signal.INPUT);
  public Signal pusherExtend = new Signal("pusherExtend", Signal.OUTPUT);
  public Signal vacOn = new Signal("vacOn", Signal.OUTPUT);
  public Signal armSource = new Signal("armSource", Signal.OUTPUT);
  public Signal armDest = new Signal("armDest", Signal.OUTPUT);
  private Signal automatic_1;
  private Signal manual_1;
  private Integer var_mode_thread_6;//sysj\controller.sysj line: 130, column: 3
  private int S396 = 1;
  private int S231 = 1;
  private int S77 = 1;
  private int S6 = 1;
  private int S37 = 1;
  private int S34 = 1;
  private int S33 = 1;
  private int S350 = 1;
  private int S394 = 1;
  
  private int[] ends = new int[7];
  private int[] tdone = new int[7];
  
  public void thread413(int [] tdone, int [] ends){
        switch(S394){
      case 0 : 
        active[6]=0;
        ends[6]=0;
        tdone[6]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\controller.sysj line: 132, column: 13
          var_mode_thread_6 = (mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 133, column: 5
          System.out.println("varMode" + var_mode_thread_6);//sysj\controller.sysj line: 134, column: 5
          if(var_mode_thread_6 == 0){//sysj\controller.sysj line: 136, column: 9
            automatic_1.setPresent();//sysj\controller.sysj line: 137, column: 6
            currsigs.addElement(automatic_1);
            active[6]=1;
            ends[6]=1;
            tdone[6]=1;
          }
          else {
            if(var_mode_thread_6 == 1){//sysj\controller.sysj line: 138, column: 15
              manual_1.setPresent();//sysj\controller.sysj line: 139, column: 6
              currsigs.addElement(manual_1);
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
            else {
              active[6]=1;
              ends[6]=1;
              tdone[6]=1;
            }
          }
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        break;
      
    }
  }

  public void thread412(int [] tdone, int [] ends){
        switch(S350){
      case 0 : 
        active[5]=0;
        ends[5]=0;
        tdone[5]=1;
        break;
      
      case 1 : 
        if(manual_1.getprestatus()){//sysj\controller.sysj line: 104, column: 13
          if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 105, column: 14
            pusherExtend.setPresent();//sysj\controller.sysj line: 106, column: 6
            currsigs.addElement(pusherExtend);
            System.out.println("pusherExtendM");//sysj\controller.sysj line: 107, column: 6
            if(vacOnM.getprestatus()){//sysj\controller.sysj line: 110, column: 14
              vacOn.setPresent();//sysj\controller.sysj line: 111, column: 6
              currsigs.addElement(vacOn);
              System.out.println("vacOn");//sysj\controller.sysj line: 112, column: 6
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
            else {
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
          }
          else {
            if(vacOnM.getprestatus()){//sysj\controller.sysj line: 110, column: 14
              vacOn.setPresent();//sysj\controller.sysj line: 111, column: 6
              currsigs.addElement(vacOn);
              System.out.println("vacOn");//sysj\controller.sysj line: 112, column: 6
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
            else {
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
                  currsigs.addElement(armDest);
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
                else {
                  active[5]=1;
                  ends[5]=1;
                  tdone[5]=1;
                }
              }
            }
          }
        }
        else {
          active[5]=1;
          ends[5]=1;
          tdone[5]=1;
        }
        break;
      
    }
  }

  public void thread410(int [] tdone, int [] ends){
        armDest.setPresent();//sysj\controller.sysj line: 71, column: 41
    currsigs.addElement(armDest);
    active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread409(int [] tdone, int [] ends){
        S34=1;
    vacOn.setPresent();//sysj\controller.sysj line: 71, column: 24
    currsigs.addElement(vacOn);
    S34=0;
    active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread407(int [] tdone, int [] ends){
        active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread406(int [] tdone, int [] ends){
        switch(S34){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        switch(S33){
        }
        break;
      
    }
  }

  public void thread404(int [] tdone, int [] ends){
        armDest.setPresent();//sysj\controller.sysj line: 71, column: 41
    currsigs.addElement(armDest);
    active[4]=0;
    ends[4]=0;
    tdone[4]=1;
  }

  public void thread403(int [] tdone, int [] ends){
        S34=1;
    vacOn.setPresent();//sysj\controller.sysj line: 71, column: 24
    currsigs.addElement(vacOn);
    S34=0;
    active[3]=0;
    ends[3]=0;
    tdone[3]=1;
  }

  public void thread402(int [] tdone, int [] ends){
        switch(S231){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S77){
          case 0 : 
            switch(S6){
              case 0 : 
                if(armAtDest.getprestatus()){//sysj\controller.sysj line: 18, column: 13
                  S6=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  armDest.setPresent();//sysj\controller.sysj line: 20, column: 23
                  currsigs.addElement(armDest);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                S6=1;
                S6=2;
                pusherExtend.setPresent();//sysj\controller.sysj line: 31, column: 23
                currsigs.addElement(pusherExtend);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 2 : 
                if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 29, column: 13
                  S6=3;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  pusherExtend.setPresent();//sysj\controller.sysj line: 31, column: 23
                  currsigs.addElement(pusherExtend);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 3 : 
                S6=3;
                S6=4;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 4 : 
                if(pusherRetracted.getprestatus()){//sysj\controller.sysj line: 40, column: 13
                  System.out.println("retracted");//sysj\controller.sysj line: 47, column: 6
                  S6=5;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 5 : 
                S6=5;
                S6=6;
                armSource.setPresent();//sysj\controller.sysj line: 54, column: 23
                currsigs.addElement(armSource);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 6 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 52, column: 13
                  S6=7;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  armSource.setPresent();//sysj\controller.sysj line: 54, column: 23
                  currsigs.addElement(armSource);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 7 : 
                S6=7;
                S6=8;
                vacOn.setPresent();//sysj\controller.sysj line: 64, column: 23
                currsigs.addElement(vacOn);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 8 : 
                if(WPgripped.getprestatus()){//sysj\controller.sysj line: 62, column: 13
                  S6=9;
                  S37=0;
                  thread403(tdone,ends);
                  thread404(tdone,ends);
                  int biggest405 = 0;
                  if(ends[3]>=biggest405){
                    biggest405=ends[3];
                  }
                  if(ends[4]>=biggest405){
                    biggest405=ends[4];
                  }
                  //FINXME code
                  if(biggest405 == 0){
                    S37=1;
                    active[2]=1;
                    ends[2]=1;
                    tdone[2]=1;
                  }
                }
                else {
                  vacOn.setPresent();//sysj\controller.sysj line: 64, column: 23
                  currsigs.addElement(vacOn);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 9 : 
                if(armAtDest.getprestatus()){//sysj\controller.sysj line: 69, column: 13
                  S6=10;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  switch(S37){
                    case 0 : 
                      thread406(tdone,ends);
                      thread407(tdone,ends);
                      int biggest408 = 0;
                      if(ends[3]>=biggest408){
                        biggest408=ends[3];
                      }
                      if(ends[4]>=biggest408){
                        biggest408=ends[4];
                      }
                      //FINXME code
                      if(biggest408 == 0){
                        S37=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                    case 1 : 
                      S37=1;
                      S37=0;
                      thread409(tdone,ends);
                      thread410(tdone,ends);
                      int biggest411 = 0;
                      if(ends[3]>=biggest411){
                        biggest411=ends[3];
                      }
                      if(ends[4]>=biggest411){
                        biggest411=ends[4];
                      }
                      //FINXME code
                      if(biggest411 == 0){
                        S37=1;
                        active[2]=1;
                        ends[2]=1;
                        tdone[2]=1;
                      }
                      break;
                    
                  }
                }
                break;
              
              case 10 : 
                S6=10;
                S6=11;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 11 : 
                if(!WPgripped.getprestatus()){//sysj\controller.sysj line: 78, column: 13
                  S6=12;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 12 : 
                S6=12;
                S6=13;
                armSource.setPresent();//sysj\controller.sysj line: 88, column: 23
                currsigs.addElement(armSource);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
                break;
              
              case 13 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 86, column: 13
                  S77=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  armSource.setPresent();//sysj\controller.sysj line: 88, column: 23
                  currsigs.addElement(armSource);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S77=1;
            S77=0;
            if(automatic_1.getprestatus()){//sysj\controller.sysj line: 15, column: 13
              if(request.getprestatus()){//sysj\controller.sysj line: 16, column: 14
                S6=0;
                armDest.setPresent();//sysj\controller.sysj line: 20, column: 23
                currsigs.addElement(armDest);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S77=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S77=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread400(int [] tdone, int [] ends){
        S394=1;
        if(mode.getprestatus()){//sysj\controller.sysj line: 132, column: 13
      var_mode_thread_6 = (mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 133, column: 5
      System.out.println("varMode" + var_mode_thread_6);//sysj\controller.sysj line: 134, column: 5
      if(var_mode_thread_6 == 0){//sysj\controller.sysj line: 136, column: 9
        automatic_1.setPresent();//sysj\controller.sysj line: 137, column: 6
        currsigs.addElement(automatic_1);
        active[6]=1;
        ends[6]=1;
        tdone[6]=1;
      }
      else {
        if(var_mode_thread_6 == 1){//sysj\controller.sysj line: 138, column: 15
          manual_1.setPresent();//sysj\controller.sysj line: 139, column: 6
          currsigs.addElement(manual_1);
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
        else {
          active[6]=1;
          ends[6]=1;
          tdone[6]=1;
        }
      }
    }
    else {
      active[6]=1;
      ends[6]=1;
      tdone[6]=1;
    }
  }

  public void thread399(int [] tdone, int [] ends){
        S350=1;
    if(manual_1.getprestatus()){//sysj\controller.sysj line: 104, column: 13
      if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 105, column: 14
        pusherExtend.setPresent();//sysj\controller.sysj line: 106, column: 6
        currsigs.addElement(pusherExtend);
        System.out.println("pusherExtendM");//sysj\controller.sysj line: 107, column: 6
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 110, column: 14
          vacOn.setPresent();//sysj\controller.sysj line: 111, column: 6
          currsigs.addElement(vacOn);
          System.out.println("vacOn");//sysj\controller.sysj line: 112, column: 6
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
        else {
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
      }
      else {
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 110, column: 14
          vacOn.setPresent();//sysj\controller.sysj line: 111, column: 6
          currsigs.addElement(vacOn);
          System.out.println("vacOn");//sysj\controller.sysj line: 112, column: 6
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
        else {
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 114, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 115, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 116, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 119, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 120, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 121, column: 6
              currsigs.addElement(armDest);
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
            else {
              active[5]=1;
              ends[5]=1;
              tdone[5]=1;
            }
          }
        }
      }
    }
    else {
      active[5]=1;
      ends[5]=1;
      tdone[5]=1;
    }
  }

  public void thread398(int [] tdone, int [] ends){
        S231=1;
    S77=0;
    if(automatic_1.getprestatus()){//sysj\controller.sysj line: 15, column: 13
      if(request.getprestatus()){//sysj\controller.sysj line: 16, column: 14
        S6=0;
        armDest.setPresent();//sysj\controller.sysj line: 20, column: 23
        currsigs.addElement(armDest);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S77=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      S77=1;
      active[2]=1;
      ends[2]=1;
      tdone[2]=1;
    }
  }

  public void runClockDomain(){
    for(int i=0;i<ends.length;i++){
      ends[i] = 0;
      tdone[i] = 0;
    }
    
    RUN: while(true){
      switch(S396){
        case 0 : 
          S396=0;
          break RUN;
        
        case 1 : 
          S396=2;
          S396=2;
          automatic_1.setClear();//sysj\controller.sysj line: 10, column: 2
          manual_1.setClear();//sysj\controller.sysj line: 11, column: 2
          thread398(tdone,ends);
          thread399(tdone,ends);
          thread400(tdone,ends);
          int biggest401 = 0;
          if(ends[2]>=biggest401){
            biggest401=ends[2];
          }
          if(ends[5]>=biggest401){
            biggest401=ends[5];
          }
          if(ends[6]>=biggest401){
            biggest401=ends[6];
          }
          if(biggest401 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          automatic_1.setClear();//sysj\controller.sysj line: 10, column: 2
          manual_1.setClear();//sysj\controller.sysj line: 11, column: 2
          thread402(tdone,ends);
          thread412(tdone,ends);
          thread413(tdone,ends);
          int biggest414 = 0;
          if(ends[2]>=biggest414){
            biggest414=ends[2];
          }
          if(ends[5]>=biggest414){
            biggest414=ends[5];
          }
          if(ends[6]>=biggest414){
            biggest414=ends[6];
          }
          if(biggest414 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest414 == 0){
            S396=0;
            active[1]=0;
            ends[1]=0;
            S396=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0, 0, 0};
    paused = paused1;
    active = active1;
    suspended = suspended1;
    // Now instantiate all the local signals ONLY
    automatic_1 = new Signal();
    manual_1 = new Signal();
    // --------------------------------------------------
  }
  
  public void run(){
    while(active[1] != 0){
      int index = 1;
      if(paused[index]==1 || suspended[index]==1 || active[index] == 0){
        for(int h=1;h<paused.length;++h){
          paused[h]=0;
        }
      }
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        if(!df){
          pusherRetracted.gethook();
          pusherExtended.gethook();
          WPgripped.gethook();
          armAtSource.gethook();
          armAtDest.gethook();
          empty.gethook();
          request.gethook();
          mode.gethook();
          pusherExtendM.gethook();
          vacOnM.gethook();
          armSourceM.gethook();
          armDestM.gethook();
          df = true;
        }
        runClockDomain();
      }
      pusherRetracted.setpreclear();
      pusherExtended.setpreclear();
      WPgripped.setpreclear();
      armAtSource.setpreclear();
      armAtDest.setpreclear();
      empty.setpreclear();
      request.setpreclear();
      mode.setpreclear();
      pusherExtendM.setpreclear();
      vacOnM.setpreclear();
      armSourceM.setpreclear();
      armDestM.setpreclear();
      pusherExtend.setpreclear();
      vacOn.setpreclear();
      armSource.setpreclear();
      armDest.setpreclear();
      automatic_1.setpreclear();
      manual_1.setpreclear();
      int dummyint = 0;
      for(int qw=0;qw<currsigs.size();++qw){
        dummyint = ((Signal)currsigs.elementAt(qw)).getStatus() ? ((Signal)currsigs.elementAt(qw)).setprepresent() : ((Signal)currsigs.elementAt(qw)).setpreclear();
        ((Signal)currsigs.elementAt(qw)).setpreval(((Signal)currsigs.elementAt(qw)).getValue());
      }
      currsigs.removeAllElements();
      dummyint = pusherRetracted.getStatus() ? pusherRetracted.setprepresent() : pusherRetracted.setpreclear();
      pusherRetracted.setpreval(pusherRetracted.getValue());
      pusherRetracted.setClear();
      dummyint = pusherExtended.getStatus() ? pusherExtended.setprepresent() : pusherExtended.setpreclear();
      pusherExtended.setpreval(pusherExtended.getValue());
      pusherExtended.setClear();
      dummyint = WPgripped.getStatus() ? WPgripped.setprepresent() : WPgripped.setpreclear();
      WPgripped.setpreval(WPgripped.getValue());
      WPgripped.setClear();
      dummyint = armAtSource.getStatus() ? armAtSource.setprepresent() : armAtSource.setpreclear();
      armAtSource.setpreval(armAtSource.getValue());
      armAtSource.setClear();
      dummyint = armAtDest.getStatus() ? armAtDest.setprepresent() : armAtDest.setpreclear();
      armAtDest.setpreval(armAtDest.getValue());
      armAtDest.setClear();
      dummyint = empty.getStatus() ? empty.setprepresent() : empty.setpreclear();
      empty.setpreval(empty.getValue());
      empty.setClear();
      dummyint = request.getStatus() ? request.setprepresent() : request.setpreclear();
      request.setpreval(request.getValue());
      request.setClear();
      dummyint = mode.getStatus() ? mode.setprepresent() : mode.setpreclear();
      mode.setpreval(mode.getValue());
      mode.setClear();
      dummyint = pusherExtendM.getStatus() ? pusherExtendM.setprepresent() : pusherExtendM.setpreclear();
      pusherExtendM.setpreval(pusherExtendM.getValue());
      pusherExtendM.setClear();
      dummyint = vacOnM.getStatus() ? vacOnM.setprepresent() : vacOnM.setpreclear();
      vacOnM.setpreval(vacOnM.getValue());
      vacOnM.setClear();
      dummyint = armSourceM.getStatus() ? armSourceM.setprepresent() : armSourceM.setpreclear();
      armSourceM.setpreval(armSourceM.getValue());
      armSourceM.setClear();
      dummyint = armDestM.getStatus() ? armDestM.setprepresent() : armDestM.setpreclear();
      armDestM.setpreval(armDestM.getValue());
      armDestM.setClear();
      pusherExtend.sethook();
      pusherExtend.setClear();
      vacOn.sethook();
      vacOn.setClear();
      armSource.sethook();
      armSource.setClear();
      armDest.sethook();
      armDest.setClear();
      automatic_1.setClear();
      manual_1.setClear();
      if(paused[1]!=0 || suspended[1]!=0 || active[1]!=1);
      else{
        pusherRetracted.gethook();
        pusherExtended.gethook();
        WPgripped.gethook();
        armAtSource.gethook();
        armAtDest.gethook();
        empty.gethook();
        request.gethook();
        mode.gethook();
        pusherExtendM.gethook();
        vacOnM.gethook();
        armSourceM.gethook();
        armDestM.gethook();
      }
      runFinisher();
      if(active[1] == 0){
      	this.terminated = true;
      }
      if(!threaded) break;
    }
  }
}
