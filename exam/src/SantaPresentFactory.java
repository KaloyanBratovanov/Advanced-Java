import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SantaPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
// push
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(materials::push);

        ArrayDeque<Integer> magic = Arrays.stream(scanner.nextLine().split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int dollCount= 0;
        int woodenTrainCount = 0;
        int teddyBearCount = 0;
        int bicycleCount = 0;


        while (!materials.isEmpty() && !magic.isEmpty()){

            int materialsFirst = materials.peek();
            int magicFirst = magic.peek();
            if (materialsFirst == 0){
                materials.pop();
                continue;
            }
            if (magicFirst == 0){
                magic.poll();
                continue;
            }

            int sum = materialsFirst  * magicFirst;

            if (sum < 0 ){
                int secSum = materials.pop() + magic.poll();
                materials.push(secSum);
                continue;
            }

            switch (sum){
                case 150:
                    materials.pop();
                    magic.poll();
                    dollCount ++;
                    break;
                case 250:
                    materials.pop();
                    magic.poll();
                    woodenTrainCount ++;
                    break;
                case 300:
                    materials.pop();
                    magic.poll();
                    teddyBearCount ++;
                    break;
                case 400:
                    materials.pop();
                    magic.poll();
                    bicycleCount ++;
                    break;
                default:
                    magic.poll();
                    materials.push(materials.pop()+15);
                    break;
            }


        }

        if (dollCount >0 && woodenTrainCount >0 || teddyBearCount >0 && bicycleCount >0){
            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if (materials.size() >0 ){
            System.out.print("Materials left: ");
            System.out.println(materials.stream().map(String::valueOf)
                    .collect(Collectors.joining(", ")));
        }
        if (magic.size() >0 ){
            System.out.println("Magic left: ");
            System.out.println((magic.stream().map(String::valueOf)
                    .collect(Collectors.joining(", "))));
        }

        if (bicycleCount >0){
            System.out.println(String.format("Bicycle: %d",bicycleCount));
        }
        if (dollCount >0){
            System.out.println(String.format("Doll: %d",dollCount));
        }


        if (teddyBearCount > 0){
            System.out.println(String.format("Teddy bear: %d",teddyBearCount));
        }
        if (woodenTrainCount > 0){
            System.out.println(String.format("Wooden train: %d",woodenTrainCount));
        }



    }
}


//import java.util.*;
//import java.util.stream.Collectors;
//
//public class SantaPresentFactory {
//
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        ArrayDeque<Integer> materials = new ArrayDeque<>();
//// push
//        Arrays.stream(scanner.nextLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .forEach(materials::push);
//
//        ArrayDeque<Integer> magic = Arrays.stream(scanner.nextLine().split("\\s"))
//                .map(Integer::parseInt)
//                .collect(Collectors.toCollection(ArrayDeque::new));
////Doll	150
////Wooden train	250
////Teddy bear	300
////Bicycle 	400
//
//        Map<String,Integer> present  = new TreeMap<>();
//
//        present.put("Doll:", 0);
//        present.put("Wooden train:", 0);
//        present.put("Teddy bear:", 0);
//        present.put("Bicycle:", 0);
//
//
//
//
//
//       while (!materials.isEmpty() && !magic.isEmpty()){
//
//           int mat = materials.peek();
//           int mag = magic.peek();
//
//           if (mat == 0 ){
//               materials.pop();
//               continue;
//           }
//
//           if (mag == 0 ){
//               magic.poll();
//               continue;
//           }
//
//           int sum = mat * mag;
//
//           if (sum < 0){
//               int secSum = mat + mag;
//               materials.pop();
//               magic.poll();
//               materials.push(secSum);
//           }
//
//           switch (sum) {
//               case 150:
//                   materials.pop();
//                   magic.poll();
//                   present.put("Doll:", present.get("Doll:") + 1);
//                   break;
//               case 250:
//                   materials.pop();
//                   magic.poll();
//                   present.put("Wooden train:", present.get("Wooden train:") + 1);
//                   break;
//               case 300:
//                   materials.pop();
//                   magic.poll();
//                   present.put("Teddy bear:", present.get("Teddy bear:") + 1);
//                   break;
//               case 400:
//                   materials.pop();
//                   magic.poll();
//                   present.put("Bicycle:", present.get("Bicycle:") + 1);
//                   break;
//               default:
//                        if (sum >=0 ){
//
//                            magic.poll();
//                            materials.push(materials.pop() + 15);
//                        }
//
//                   break;
//           }
//
//       }
//
//       if (present.get("Doll:") >0 && present.get("Wooden train:") > 0
//       || present.get("Teddy bear:") > 0 && present.get("Bicycle:") > 0){
//           System.out.println("The presents are crafted! Merry Christmas!");
//       }else {
//           System.out.println("No presents this Christmas!");
//       }
//
//       if (!materials.isEmpty()){
//           System.out.print("Materials left: ");
//           System.out.println(materials.stream().map(String::valueOf)
//                   .collect(Collectors.joining(", ")));
//       }
//        if (!magic.isEmpty()){
//            System.out.print("Magic left: ");
//            System.out.println(materials.stream().map(String::valueOf)
//                    .collect(Collectors.joining(", ")));
//        }
//
//        for (Map.Entry<String, Integer> entry : present.entrySet()) {
//            if (entry.getValue() > 0){
//                System.out.println(entry.getKey() + " "+ entry.getValue());
//            }
//        }
//    }
//
//}