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
  private Integer var_mode_thread_4;//sysj\controller.sysj line: 96, column: 3
  private int S288 = 1;
  private int S123 = 1;
  private int S41 = 1;
  private int S14 = 1;
  private int S242 = 1;
  private int S286 = 1;
  
  private int[] ends = new int[5];
  private int[] tdone = new int[5];
  
  public void thread296(int [] tdone, int [] ends){
        switch(S286){
      case 0 : 
        active[4]=0;
        ends[4]=0;
        tdone[4]=1;
        break;
      
      case 1 : 
        if(mode.getprestatus()){//sysj\controller.sysj line: 98, column: 13
          var_mode_thread_4 = (mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 99, column: 5
          System.out.println("varMode" + var_mode_thread_4);//sysj\controller.sysj line: 100, column: 5
          if(var_mode_thread_4 == 0){//sysj\controller.sysj line: 102, column: 9
            automatic_1.setPresent();//sysj\controller.sysj line: 103, column: 6
            currsigs.addElement(automatic_1);
            active[4]=1;
            ends[4]=1;
            tdone[4]=1;
          }
          else {
            if(var_mode_thread_4 == 1){//sysj\controller.sysj line: 104, column: 15
              manual_1.setPresent();//sysj\controller.sysj line: 105, column: 6
              currsigs.addElement(manual_1);
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
            else {
              active[4]=1;
              ends[4]=1;
              tdone[4]=1;
            }
          }
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        break;
      
    }
  }

  public void thread295(int [] tdone, int [] ends){
        switch(S242){
      case 0 : 
        active[3]=0;
        ends[3]=0;
        tdone[3]=1;
        break;
      
      case 1 : 
        if(manual_1.getprestatus()){//sysj\controller.sysj line: 70, column: 13
          if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 71, column: 14
            pusherExtend.setPresent();//sysj\controller.sysj line: 72, column: 6
            currsigs.addElement(pusherExtend);
            System.out.println("pusherExtendM");//sysj\controller.sysj line: 73, column: 6
            if(vacOnM.getprestatus()){//sysj\controller.sysj line: 76, column: 14
              vacOn.setPresent();//sysj\controller.sysj line: 77, column: 6
              currsigs.addElement(vacOn);
              System.out.println("vacOn");//sysj\controller.sysj line: 78, column: 6
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
          }
          else {
            if(vacOnM.getprestatus()){//sysj\controller.sysj line: 76, column: 14
              vacOn.setPresent();//sysj\controller.sysj line: 77, column: 6
              currsigs.addElement(vacOn);
              System.out.println("vacOn");//sysj\controller.sysj line: 78, column: 6
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
            else {
              if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
                armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
                currsigs.addElement(armSource);
                System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
              else {
                if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
                  System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
                  armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
                  currsigs.addElement(armDest);
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
                else {
                  active[3]=1;
                  ends[3]=1;
                  tdone[3]=1;
                }
              }
            }
          }
        }
        else {
          active[3]=1;
          ends[3]=1;
          tdone[3]=1;
        }
        break;
      
    }
  }

  public void thread294(int [] tdone, int [] ends){
        switch(S123){
      case 0 : 
        active[2]=0;
        ends[2]=0;
        tdone[2]=1;
        break;
      
      case 1 : 
        switch(S41){
          case 0 : 
            switch(S14){
              case 0 : 
                if(pusherExtended.getprestatus()){//sysj\controller.sysj line: 17, column: 13
                  S14=1;
                  armSource.setPresent();//sysj\controller.sysj line: 27, column: 23
                  currsigs.addElement(armSource);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  pusherExtend.setPresent();//sysj\controller.sysj line: 19, column: 23
                  currsigs.addElement(pusherExtend);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 1 : 
                if(armAtSource.getprestatus()){//sysj\controller.sysj line: 25, column: 13
                  S14=2;
                  vacOn.setPresent();//sysj\controller.sysj line: 36, column: 23
                  currsigs.addElement(vacOn);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  armSource.setPresent();//sysj\controller.sysj line: 27, column: 23
                  currsigs.addElement(armSource);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 2 : 
                if(WPgripped.getprestatus()){//sysj\controller.sysj line: 34, column: 13
                  S14=3;
                  vacOn.setPresent();//sysj\controller.sysj line: 45, column: 8
                  currsigs.addElement(vacOn);
                  armDest.setPresent();//sysj\controller.sysj line: 46, column: 23
                  currsigs.addElement(armDest);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  vacOn.setPresent();//sysj\controller.sysj line: 36, column: 23
                  currsigs.addElement(vacOn);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 3 : 
                if(armAtDest.getprestatus()){//sysj\controller.sysj line: 43, column: 13
                  S14=4;
                  pusherExtend.setPresent();//sysj\controller.sysj line: 55, column: 23
                  currsigs.addElement(pusherExtend);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  vacOn.setPresent();//sysj\controller.sysj line: 45, column: 8
                  currsigs.addElement(vacOn);
                  armDest.setPresent();//sysj\controller.sysj line: 46, column: 23
                  currsigs.addElement(armDest);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
              case 4 : 
                if(!WPgripped.getprestatus()){//sysj\controller.sysj line: 53, column: 13
                  S41=1;
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                else {
                  pusherExtend.setPresent();//sysj\controller.sysj line: 55, column: 23
                  currsigs.addElement(pusherExtend);
                  active[2]=1;
                  ends[2]=1;
                  tdone[2]=1;
                }
                break;
              
            }
            break;
          
          case 1 : 
            S41=1;
            S41=0;
            if(automatic_1.getprestatus()){//sysj\controller.sysj line: 15, column: 13
              if(request.getprestatus()){//sysj\controller.sysj line: 16, column: 14
                S14=0;
                pusherExtend.setPresent();//sysj\controller.sysj line: 19, column: 23
                currsigs.addElement(pusherExtend);
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
              else {
                S41=1;
                active[2]=1;
                ends[2]=1;
                tdone[2]=1;
              }
            }
            else {
              S41=1;
              active[2]=1;
              ends[2]=1;
              tdone[2]=1;
            }
            break;
          
        }
        break;
      
    }
  }

  public void thread292(int [] tdone, int [] ends){
        S286=1;
        if(mode.getprestatus()){//sysj\controller.sysj line: 98, column: 13
      var_mode_thread_4 = (mode.getpreval() == null ? null : ((Integer)mode.getpreval()));//sysj\controller.sysj line: 99, column: 5
      System.out.println("varMode" + var_mode_thread_4);//sysj\controller.sysj line: 100, column: 5
      if(var_mode_thread_4 == 0){//sysj\controller.sysj line: 102, column: 9
        automatic_1.setPresent();//sysj\controller.sysj line: 103, column: 6
        currsigs.addElement(automatic_1);
        active[4]=1;
        ends[4]=1;
        tdone[4]=1;
      }
      else {
        if(var_mode_thread_4 == 1){//sysj\controller.sysj line: 104, column: 15
          manual_1.setPresent();//sysj\controller.sysj line: 105, column: 6
          currsigs.addElement(manual_1);
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
        else {
          active[4]=1;
          ends[4]=1;
          tdone[4]=1;
        }
      }
    }
    else {
      active[4]=1;
      ends[4]=1;
      tdone[4]=1;
    }
  }

  public void thread291(int [] tdone, int [] ends){
        S242=1;
    if(manual_1.getprestatus()){//sysj\controller.sysj line: 70, column: 13
      if(pusherExtendM.getprestatus()){//sysj\controller.sysj line: 71, column: 14
        pusherExtend.setPresent();//sysj\controller.sysj line: 72, column: 6
        currsigs.addElement(pusherExtend);
        System.out.println("pusherExtendM");//sysj\controller.sysj line: 73, column: 6
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 76, column: 14
          vacOn.setPresent();//sysj\controller.sysj line: 77, column: 6
          currsigs.addElement(vacOn);
          System.out.println("vacOn");//sysj\controller.sysj line: 78, column: 6
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        else {
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
      }
      else {
        if(vacOnM.getprestatus()){//sysj\controller.sysj line: 76, column: 14
          vacOn.setPresent();//sysj\controller.sysj line: 77, column: 6
          currsigs.addElement(vacOn);
          System.out.println("vacOn");//sysj\controller.sysj line: 78, column: 6
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
        else {
          if(armSourceM.getprestatus()){//sysj\controller.sysj line: 80, column: 14
            armSource.setPresent();//sysj\controller.sysj line: 81, column: 6
            currsigs.addElement(armSource);
            System.out.println("armSourceM");//sysj\controller.sysj line: 82, column: 6
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
          else {
            if(armDestM.getprestatus()){//sysj\controller.sysj line: 85, column: 14
              System.out.println("armDest");//sysj\controller.sysj line: 86, column: 6
              armDest.setPresent();//sysj\controller.sysj line: 87, column: 6
              currsigs.addElement(armDest);
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
            else {
              active[3]=1;
              ends[3]=1;
              tdone[3]=1;
            }
          }
        }
      }
    }
    else {
      active[3]=1;
      ends[3]=1;
      tdone[3]=1;
    }
  }

  public void thread290(int [] tdone, int [] ends){
        S123=1;
    S41=0;
    if(automatic_1.getprestatus()){//sysj\controller.sysj line: 15, column: 13
      if(request.getprestatus()){//sysj\controller.sysj line: 16, column: 14
        S14=0;
        pusherExtend.setPresent();//sysj\controller.sysj line: 19, column: 23
        currsigs.addElement(pusherExtend);
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
      else {
        S41=1;
        active[2]=1;
        ends[2]=1;
        tdone[2]=1;
      }
    }
    else {
      S41=1;
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
      switch(S288){
        case 0 : 
          S288=0;
          break RUN;
        
        case 1 : 
          S288=2;
          S288=2;
          automatic_1.setClear();//sysj\controller.sysj line: 10, column: 2
          manual_1.setClear();//sysj\controller.sysj line: 11, column: 2
          thread290(tdone,ends);
          thread291(tdone,ends);
          thread292(tdone,ends);
          int biggest293 = 0;
          if(ends[2]>=biggest293){
            biggest293=ends[2];
          }
          if(ends[3]>=biggest293){
            biggest293=ends[3];
          }
          if(ends[4]>=biggest293){
            biggest293=ends[4];
          }
          if(biggest293 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
        
        case 2 : 
          automatic_1.setClear();//sysj\controller.sysj line: 10, column: 2
          manual_1.setClear();//sysj\controller.sysj line: 11, column: 2
          thread294(tdone,ends);
          thread295(tdone,ends);
          thread296(tdone,ends);
          int biggest297 = 0;
          if(ends[2]>=biggest297){
            biggest297=ends[2];
          }
          if(ends[3]>=biggest297){
            biggest297=ends[3];
          }
          if(ends[4]>=biggest297){
            biggest297=ends[4];
          }
          if(biggest297 == 1){
            active[1]=1;
            ends[1]=1;
            break RUN;
          }
          //FINXME code
          if(biggest297 == 0){
            S288=0;
            active[1]=0;
            ends[1]=0;
            S288=0;
            break RUN;
          }
        
      }
    }
  }

  public void init(){
    char [] active1 = {1, 1, 1, 1, 1};
    char [] paused1 = {0, 0, 0, 0, 0};
    char [] suspended1 = {0, 0, 0, 0, 0};
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
