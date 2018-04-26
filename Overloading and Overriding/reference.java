// A program without packages? That's unlike you...
// Learn how super() and "this" keyword works.
class box{
        double w,h,d;
        box(double w,double h,double d){
                this.w=w;
                this.h=h;
                this.d=d;
         }
        public double volume(){
                return w*h*d;
        }
}

class boxweight extends box{
        double weight;
        boxweight(double w,double h,double d,double m){
                /*this.w=w;
                this.h=h;
                this.d=d;
                 */
                super(w,h,d);
                weight=m;
        }
        public double volume(){
                return w*h*d;
        }
}

class reference{
        public static void main(String args[]){
                box plainBox = new box(4,2,3);
                boxweight weightBox = new boxweight(1,2,3,4);
                double vol1 = weightBox.volume() ,vol2 =plainBox.volume();
                System.out.println("Before superobj=referenceobj\n vol from ref "+vol1+"\nvol from super "+vol2);
                System.out.println("After plainBox vol is "+plainBox.volume());
                //System.out.println("After weight is "+plainbox.weight); // Uncomment and see what happens
                plainBox = weightBox;
                System.out.println("After trying to get volume using plainBox "+plainBox.volume());
        }
}
