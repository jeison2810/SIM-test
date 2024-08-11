import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class CubeConundrum {
    
    static int totalRed = 12, totalGreen = 13, totalBlue = 14;
    
     public static void main(String[] args) {
          //variable for not using a flat file
           String games = "Game 1: 6 green, 3 blue; 3 red, 1 green; 4 green, 3 red, 5 blue\n"+
"Game 2: 2 red, 7 green; 13 green, 2 blue, 4 red; 4 green, 5 red, 1 blue; 1 blue, 9 red, 1 green\n"+
"Game 3: 2 green, 3 blue, 9 red; 3 red, 2 green; 6 red, 4 blue; 6 red\n"+
"Game 4: 9 red, 3 green; 3 green, 8 red, 6 blue; 12 blue, 4 green, 6 red; 4 green, 18 blue, 11 red; 9 blue, 2 green, 3 red; 14 blue, 7 red\n"+
"Game 5: 1 blue, 2 green, 3 red; 16 red, 6 green; 6 green, 2 red; 9 red, 1 green\n"+
"Game 6: 4 green, 7 red, 1 blue; 18 green, 6 blue, 7 red; 1 blue, 3 red, 9 green; 9 red, 19 green, 1 blue; 7 red, 9 green, 4 blue; 5 red, 5 blue, 10 green\n"+
"Game 7: 16 blue, 5 green, 6 red; 1 blue, 6 red, 9 green; 6 green, 3 red, 2 blue; 2 red, 12 blue, 2 green\n"+
"Game 8: 6 green, 10 red; 7 red, 6 green, 17 blue; 13 blue, 1 red\n"+
"Game 9: 2 red, 4 green, 5 blue; 2 green, 5 blue; 4 green, 1 blue; 3 green, 3 red, 6 blue; 3 green\n"+
"Game 10: 3 green, 5 red, 6 blue; 4 blue, 4 red, 5 green; 5 green, 9 red, 5 blue; 4 green, 6 blue, 10 red\n"+
"Game 11: 1 blue, 7 red, 9 green; 1 blue, 13 red, 7 green; 5 red; 4 red, 7 green, 2 blue; 7 green, 12 red; 13 red, 2 blue, 12 green\n"+
"Game 12: 4 blue, 2 red; 9 blue, 2 green, 3 red; 8 blue, 1 green, 1 red; 2 red, 3 green, 11 blue\n"+
"Game 13: 6 red, 8 green, 2 blue; 6 red, 7 green; 3 green, 3 red; 2 blue; 3 red, 5 green\n"+
"Game 14: 2 green, 11 blue, 1 red; 5 blue, 1 red, 1 green; 3 green, 12 blue, 2 red\n"+
"Game 15: 4 blue, 6 red, 7 green; 1 red, 2 blue, 5 green; 6 red, 3 green, 8 blue; 7 green, 8 blue, 4 red\n"+
"Game 16: 2 red, 16 blue; 2 green, 7 red; 15 blue, 7 red; 2 red, 3 green, 3 blue; 3 red, 1 green, 4 blue; 4 blue, 3 green\n"+
"Game 17: 2 red, 3 green, 10 blue; 9 red, 4 blue, 3 green; 3 green, 11 red, 6 blue\n"+
"Game 18: 1 red; 6 green, 1 red, 9 blue; 4 blue, 2 green; 6 blue, 10 green\n"+
"Game 19: 2 red, 9 green; 2 red, 1 blue; 5 blue, 12 green; 5 green; 8 green, 2 red, 3 blue; 1 red, 11 green\n"+
"Game 20: 3 green, 2 red, 7 blue; 1 blue, 10 green; 1 red, 14 blue, 13 green; 3 green, 19 blue, 4 red\n"+
"Game 21: 8 red, 10 blue, 8 green; 2 red, 7 green, 18 blue; 4 green, 11 blue, 4 red; 5 green, 3 blue, 10 red\n"+
"Game 22: 17 blue, 2 green, 2 red; 8 red, 7 blue; 1 red, 9 blue, 1 green\n"+
"Game 23: 4 blue, 18 red, 4 green; 3 blue, 7 red; 11 red; 3 blue, 6 red; 19 red\n"+
"Game 24: 10 red, 1 blue, 17 green; 17 green, 6 red; 14 green, 4 blue\n"+
"Game 25: 4 blue, 9 green, 4 red; 3 green, 5 blue; 5 blue, 8 green; 3 green, 3 blue, 1 red; 10 green, 1 blue, 4 red; 2 green, 2 blue, 1 red\n"+
"Game 26: 18 green, 3 red, 12 blue; 2 red, 7 green; 11 blue, 17 green; 12 green, 11 blue; 12 green, 4 blue, 3 red\n"+
"Game 27: 1 red, 3 blue, 8 green; 15 blue, 8 red, 4 green; 6 red, 9 blue; 6 red, 12 blue, 9 green; 4 red, 7 blue, 15 green\n"+
"Game 28: 1 red, 14 green; 1 blue, 11 green; 2 green; 4 red, 6 green, 1 blue\n"+
"Game 29: 1 green, 13 red; 4 red, 16 green, 7 blue; 2 red, 4 blue; 12 green, 8 blue, 4 red; 2 red; 12 red, 5 green\n"+
"Game 30: 3 green, 4 blue, 3 red; 5 blue, 4 green, 7 red; 5 blue, 2 green, 2 red; 3 red, 1 blue\n"+
"Game 31: 1 blue, 8 green; 9 green, 2 blue, 1 red; 1 red, 2 blue\n"+
"Game 32: 11 red, 5 green, 4 blue; 3 blue, 11 red, 8 green; 6 blue, 3 green, 17 red; 4 red, 7 green, 10 blue\n"+
"Game 33: 6 blue, 4 red; 1 green; 1 green, 4 red, 4 blue; 1 green, 3 red, 10 blue; 10 blue, 1 red\n"+
"Game 34: 2 green, 3 blue, 3 red; 4 red; 2 red, 2 blue\n"+
"Game 35: 9 green, 13 blue; 13 blue, 14 red, 1 green; 11 blue, 4 red, 7 green; 5 blue, 5 red, 8 green; 4 red, 2 blue, 2 green\n"+
"Game 36: 9 red, 5 blue, 8 green; 7 red, 20 blue; 6 green, 16 blue, 5 red; 12 red, 3 blue, 3 green; 3 green, 6 blue, 11 red; 11 red, 8 blue, 3 green\n"+
"Game 37: 10 green, 11 red, 3 blue; 2 blue, 6 green, 11 red; 9 green, 8 red, 2 blue\n"+
"Game 38: 2 red, 2 green, 4 blue; 3 red, 4 green, 3 blue; 8 green, 1 blue, 1 red; 3 red, 5 blue, 5 green\n"+
"Game 39: 3 green, 17 red, 4 blue; 2 green, 20 red; 4 blue, 4 red, 5 green; 5 blue, 7 green, 7 red; 4 blue, 5 green, 16 red\n"+
"Game 40: 2 green, 2 blue, 4 red; 3 blue, 16 green; 1 green, 2 blue; 1 red; 3 blue, 15 green; 13 green, 1 red, 2 blue\n"+
"Game 41: 12 red, 10 blue, 9 green; 1 green, 15 red, 4 blue; 2 green, 8 blue, 12 red; 3 red, 4 green, 2 blue; 8 blue, 14 red, 10 green; 9 blue, 7 green, 6 red\n"+
"Game 42: 5 red, 3 green, 6 blue; 4 blue, 6 green, 2 red; 10 blue; 3 red, 6 green, 10 blue\n"+
"Game 43: 9 blue, 7 green, 1 red; 2 green, 2 red, 8 blue; 3 red, 15 blue, 11 green; 1 red, 6 blue, 1 green; 2 red, 1 blue; 1 red, 3 green, 7 blue\n"+
"Game 44: 4 green, 6 red; 15 green, 6 red; 9 green, 16 red, 7 blue; 11 green, 4 blue, 12 red\n"+
"Game 45: 3 blue, 6 green, 1 red; 4 green, 3 blue; 8 green, 3 blue\n"+
"Game 46: 10 red, 8 blue; 12 red, 2 green, 17 blue; 17 blue, 6 red, 1 green; 18 red, 6 green, 3 blue; 16 blue, 2 green, 3 red\n"+
"Game 47: 8 green, 13 red; 8 green, 8 red, 4 blue; 10 red, 3 green; 14 red, 5 green, 8 blue; 7 green, 19 red, 3 blue; 2 red, 5 green, 5 blue\n"+
"Game 48: 7 green, 9 blue, 3 red; 7 blue, 1 green, 9 red; 7 green, 4 red, 1 blue; 6 green, 3 red, 1 blue\n"+
"Game 49: 2 red, 3 green; 3 blue, 2 red; 4 red, 3 blue\n"+
"Game 50: 3 red, 7 blue, 4 green; 2 green, 1 blue, 7 red; 4 red, 1 green, 5 blue\n"+
"Game 51: 11 red, 6 green, 1 blue; 7 red, 1 blue, 9 green; 15 red, 18 green; 11 green, 1 blue, 11 red; 10 green, 14 red; 1 red, 11 green, 1 blue\n"+
"Game 52: 18 blue, 1 red, 2 green; 18 blue, 3 green, 1 red; 2 green, 13 blue, 1 red\n"+
"Game 53: 2 blue, 9 red, 6 green; 1 blue, 3 red; 7 red, 6 blue, 8 green; 2 red, 3 blue, 4 green; 1 green, 2 blue, 2 red\n"+
"Game 54: 16 red, 4 blue; 1 green, 3 blue, 3 red; 2 green, 12 red; 2 green, 1 blue, 3 red; 10 blue, 6 red, 2 green\n"+
"Game 55: 1 blue, 4 red, 1 green; 2 blue, 2 red; 13 red, 4 blue, 1 green; 4 blue, 9 red; 1 green, 1 blue, 16 red\n"+
"Game 56: 12 blue, 12 green; 4 blue, 1 red, 3 green; 2 red, 12 green; 1 red, 11 green, 13 blue; 16 blue, 5 green\n"+
"Game 57: 1 blue, 3 red; 10 green, 5 red; 5 green, 2 red; 1 red, 13 green\n"+
"Game 58: 6 blue, 1 red, 6 green; 3 red, 9 blue; 4 red, 9 blue, 5 green; 1 green, 5 red, 7 blue\n"+
"Game 59: 10 red, 3 green, 3 blue; 6 blue, 11 red, 1 green; 5 green, 10 red; 16 red, 2 blue, 4 green; 3 green, 10 red\n"+
"Game 60: 2 green, 1 blue; 1 green, 1 blue, 4 red; 3 blue, 1 red, 1 green; 2 red, 2 green; 4 red\n"+
"Game 61: 5 red, 1 green, 10 blue; 9 red, 10 blue; 1 red, 2 green, 4 blue; 10 blue, 2 green, 9 red; 1 red, 12 blue, 2 green\n"+
"Game 62: 1 blue, 5 green; 4 blue, 12 green, 1 red; 7 blue, 3 green; 7 blue, 3 green; 3 blue, 1 green, 2 red; 7 blue, 1 red, 12 green\n"+
"Game 63: 4 blue, 2 green, 5 red; 1 green, 2 red, 2 blue; 4 blue, 2 red, 2 green; 1 blue, 6 red, 2 green; 6 blue, 1 red; 1 green, 9 red, 6 blue\n"+
"Game 64: 1 green; 3 green, 5 blue, 5 red; 3 red, 3 blue, 3 green; 1 green, 4 red, 6 blue; 5 red\n"+
"Game 65: 2 red; 1 blue, 1 red; 7 red, 2 blue; 1 green, 4 blue, 3 red\n"+
"Game 66: 3 red, 9 blue; 1 red, 6 blue, 15 green; 3 green, 3 red, 11 blue\n"+
"Game 67: 2 red, 1 green, 2 blue; 6 red, 1 green; 1 blue, 1 red, 4 green\n"+
"Game 68: 3 red, 1 blue; 1 green, 3 red, 2 blue; 1 green, 8 red; 2 blue, 3 red\n"+
"Game 69: 5 blue, 6 red; 1 green, 15 blue, 10 red; 1 green, 2 red, 4 blue; 5 blue, 7 red; 3 red, 1 green, 11 blue\n"+
"Game 70: 4 green, 2 red, 8 blue; 5 red, 3 blue; 10 green, 5 blue\n"+
"Game 71: 1 red, 2 blue, 9 green; 3 red, 8 green; 1 red, 2 blue, 6 green; 3 red, 6 blue, 8 green; 6 green, 3 blue, 2 red; 3 red, 8 green, 6 blue\n"+
"Game 72: 1 red, 11 green; 1 blue, 7 green, 1 red; 2 red, 12 green; 10 green, 6 red\n"+
"Game 73: 9 green, 2 red; 1 blue, 3 green; 1 blue, 1 red, 7 green; 2 blue, 9 green, 4 red; 2 blue, 3 red, 8 green; 2 green, 9 red\n"+
"Game 74: 2 green, 7 red; 1 green, 3 blue, 6 red; 4 green, 3 blue, 6 red; 2 green, 3 blue, 1 red; 3 red, 2 blue, 1 green\n"+
"Game 75: 15 green, 2 blue; 15 green, 6 red, 2 blue; 12 green, 2 blue, 1 red\n"+
"Game 76: 1 red, 9 green, 12 blue; 6 red, 12 green, 1 blue; 7 green, 2 blue, 1 red\n"+
"Game 77: 11 blue, 1 red; 7 blue, 2 red, 13 green; 10 blue, 10 green; 12 blue, 3 red\n"+
"Game 78: 4 green; 1 blue, 5 green; 5 green, 1 blue, 1 red\n"+
"Game 79: 4 green, 7 blue, 16 red; 1 blue, 10 red, 5 green; 3 green, 4 red, 3 blue; 11 blue, 18 red, 5 green\n"+
"Game 80: 1 red, 4 blue, 6 green; 14 blue, 16 red, 2 green; 2 blue, 5 red, 4 green; 2 green, 8 red; 18 red, 6 green, 2 blue; 18 red, 9 blue\n"+
"Game 81: 11 red, 8 blue, 1 green; 12 blue, 2 green, 14 red; 16 red, 2 green, 6 blue; 17 red, 2 green; 3 green, 3 blue, 15 red\n"+
"Game 82: 13 red, 1 blue, 6 green; 3 green, 12 red, 3 blue; 5 red, 3 green, 18 blue; 15 blue, 8 red\n"+
"Game 83: 9 green, 5 blue, 5 red; 8 green, 15 blue, 7 red; 4 green, 6 red, 10 blue; 5 green, 2 red\n"+
"Game 84: 2 blue, 2 green, 6 red; 2 green, 7 red, 1 blue; 3 green, 3 blue; 2 green, 3 red, 3 blue; 6 green, 4 red\n"+
"Game 85: 1 blue, 3 green, 5 red; 2 green, 2 red; 4 red, 3 blue; 2 green, 3 blue, 1 red; 4 red, 2 green, 4 blue\n"+
"Game 86: 6 red, 1 blue; 1 green, 16 red; 2 green, 1 red; 12 red, 1 blue\n"+
"Game 87: 6 red, 12 green, 1 blue; 5 blue, 6 red, 4 green; 2 blue, 5 red, 8 green\n"+
"Game 88: 3 green, 6 red, 2 blue; 3 blue, 2 green, 6 red; 1 red, 11 blue, 2 green\n"+
"Game 89: 7 red, 3 blue, 9 green; 6 red, 3 blue, 15 green; 2 blue, 6 red, 12 green; 5 red, 8 green; 3 blue, 7 red, 9 green; 5 red, 7 green\n"+
"Game 90: 2 green, 4 red, 19 blue; 13 blue, 4 red, 1 green; 14 blue, 8 green\n"+
"Game 91: 12 green, 5 blue, 4 red; 9 green, 10 blue, 1 red; 13 green, 1 blue, 4 red; 2 red, 5 blue; 2 blue, 7 green, 2 red; 5 blue, 5 green, 3 red\n"+
"Game 92: 9 red, 6 blue, 16 green; 11 green, 2 red, 7 blue; 1 green, 1 red, 3 blue; 4 green, 8 red\n"+
"Game 93: 1 green, 4 blue, 8 red; 2 red, 1 green, 2 blue; 2 blue, 9 red; 1 green, 4 blue, 3 red; 3 red, 1 green, 4 blue\n"+
"Game 94: 1 green, 7 red, 4 blue; 4 red, 3 blue; 16 blue, 9 red, 7 green; 9 red, 15 blue; 15 blue, 3 red, 6 green; 7 red, 10 blue, 12 green\n"+
"Game 95: 5 green, 6 blue; 10 green, 9 blue; 4 blue, 8 green, 2 red; 5 blue, 5 green, 1 red\n"+
"Game 96: 13 blue, 10 red, 2 green; 10 red, 2 green, 1 blue; 6 blue, 5 red, 3 green; 11 red, 3 green, 5 blue; 11 red, 2 green; 3 green, 6 blue\n"+
"Game 97: 9 green, 11 red, 8 blue; 6 red, 9 blue, 2 green; 3 red, 17 blue, 1 green\n"+
"Game 98: 14 blue, 3 green; 2 red, 15 blue, 3 green; 15 blue, 8 green, 1 red; 1 red, 8 green\n"+
"Game 99: 2 green, 7 blue; 14 red, 1 green, 4 blue; 8 blue, 13 red, 2 green; 10 green, 7 red, 10 blue\n"+
"Game 100: 5 green, 11 blue, 6 red; 5 green, 12 blue; 1 green, 14 blue, 1 red; 3 blue, 5 red, 6 green; 9 blue; 6 red";
        
        System.out.println(processGames(games));
        
        System.out.println(processPower(games));
    }
    
    
    private static int processGames(String games) {
        Pattern pattern = Pattern.compile("Game (\\d+): (.+)");
        
        String[] lines = games.split("\n");
        
        int result = 0;
        
        for (String line : lines) {
            
            Matcher matcher = pattern.matcher(line);
            
            if (matcher.matches()) {
                if (isValidGame(matcher.group(2))) {
                    result += Integer.parseInt(matcher.group(1));
                }
            }
        }
        
        return result;
    }
    
    private static Boolean isValidGame(String game) {
        Pattern pattern = Pattern.compile("(\\d+) (red|green|blue)");
        
        String[] lines = game.split(";");
        
        int red = 0, green = 0, blue = 0;
        for (String line : lines) {
            
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                
                int quantity = Integer.parseInt(matcher.group(1));
                String color = matcher.group(2);
                
                switch (color) {
                    case "red":
                        red = Math.max(red, quantity);
                        break;
                    case "green":
                        green = Math.max(green, quantity);
                        break;
                    case "blue":
                        blue = Math.max(blue, quantity);
                        break;
                    default:
                        break;
                }
            }
        }
        
        return red <= totalRed && green <= totalGreen && blue <= totalBlue;
    }
    
    private static int processPower(String games) {
        Pattern pattern = Pattern.compile("Game (\\d+): (.+)");
        
        String[] lines = games.split("\n");
        
        int result = 0;
        
        for (String line : lines) {
            
            Matcher matcher = pattern.matcher(line);
            
            if (matcher.matches()) {
                result += sumPower(matcher.group(2));
            }
        }
        
        return result;
    }
    
    private static int sumPower(String game) {
        Pattern pattern = Pattern.compile("(\\d+) (red|green|blue)");
        
        String[] lines = game.split(";");
        
        int red = 0, green = 0, blue = 0;
        for (String line : lines) {
            
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                
                int quantity = Integer.parseInt(matcher.group(1));
                String color = matcher.group(2);
                
                switch (color) {
                    case "red":
                        red = Math.max(red, quantity);
                        break;
                    case "green":
                        green = Math.max(green, quantity);
                        break;
                    case "blue":
                        blue = Math.max(blue, quantity);
                        break;
                    default:
                        break;
                }
            }
        }
        
        return red * green * blue;
    }
}