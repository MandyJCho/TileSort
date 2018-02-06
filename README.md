# TileSort

A program comparing various path finding algorithms

• the names of all the group members
Jung Cho

• a list of all your source files;
- src/ 
    - Search/
       - Basic/
            - BasicSearchable (Interface)
            - BFSearchController
            - DFSearchController
        
       - Best/ 
            - AStarSearchController
            - BestFirstSearch
            - BestFirstSearchable (interface)
            - GreedySearchController
            - Node
            - UCSearchController
            
       - Search 
       
       - Type (Enum)
   
   - Controller
   

• the platform on which your code is developed (e.g., Windows/Linux/Solaris);
   - Windows 
   - macOS
    
• documentation of any problems you had
   - I wish I had more time to better design my program so that I could have recycled more of 
   the logic. Ideally, I would have preferred to have a single findPath that all my algorithms 
   shared and kept all data in the node class even for the basic searches.
   - I had trouble matching the output for A-Star search. I traced the output by hand and showed 
   my findings with the TA and we both couldn't seem to find a reason why Move 0 XBWBW (c=2) was
   chosen on the 4th line rather than Move 2 BWXBW (c=2).
   
