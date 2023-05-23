ORG 100h

JMP debut
   tnote DW 1 DUP (5, 10, 18, 15, 12, 11, 19, 14, 9, 10)
   moyenne DW ?
; add your code here

debut:

   MOV BX, offset tnote 
   MOV CX, 10  
   MOV SI, 0        
   
   boucle:
      ADD AX, [BX][SI]
      
      ADD SI, 2
      
      LOOP boucle
      
   MOV DX, 0
   MOV BX, 10
   DIV BX
   MOV moyenne, AX

ret




