# TileSort

A program comparing various path finding algorithms

• the names of all the group members
Jung Cho

• a list of all your source files;
- src/ 
    - Search/
       - Algorithms/
            - Best/ 
                - AStarSearchController
                - BestFirstSearch
                - GreedySearchController
                - UCSearchController
            - BFSearchController
            - DFSearchController
       - Node
       - SearchFactory
       - Type (Enum)
   - Controller
   

• the platform on which your code is developed (e.g., Windows/Linux/Solaris);
   - Windows 
   - macOS
    
• documentation of any problems you had
   - Mainly had trouble with the heuristic. I kept counting the space as a tile
   and it would result in the wrong output.

• to run this
   1) IDE
       - Enter the following into the command line arguments options of your run settings
            ```
              search [-cost] <BFS|DFS|UCS|GS|A-star> <path to inputfile>
            ```
       
   2) Out File (.class)
       - cd into out/production/TileSort folder
       - run 
           ```
           java Controller search [-cost] <BFS|DFS|UCS|GS|A-star> <path to inputfile>
           ```
   
   3) JAR
       - run 
          ```
          java -jar TileSort.jar search [-cost] <BFS|DFS|UCS|GS|A-star> <path to inputfile>
          ```
    

   
