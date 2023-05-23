ORG 100h

JMP debut
   tnote DW 1 DUP  (5, 10, 18, 15, 12, 11, 19, 14, 9, 10)
   tcoeff DW 1 DUP (1, 2 , 4 , 1 , 2 , 1 , 5 , 1 , 2, 1)  
   sommeCoef DW 0  
   produitCoefNote DW 0
   moyenne DW ?

debut:

   LEA SI, tnote
   LEA DI, tcoeff
   MOV CX, 10        
   
   boucle:
      MOV AX,[SI]
      MOV BX,[DI]
      MUL BX
      ADD produitCoefNote, AX
      ADD sommeCoef, BX
      ADD SI, 2
      ADD DI, 2
      LOOP boucle      
      
   MOV AX, produitCoefNote
   MOV DX, 0
   DIV sommeCoef
   MOV moyenne, AX




