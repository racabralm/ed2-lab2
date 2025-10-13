//
// Árvore AVL (Rotações) - Exemplo de implementação em Java
// Copyright (C) 2024 André Kishimoto
//
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
//
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.
//

import ed2.AVL;

public class Main {

	public static void main(String[] args) {
		AVL avl = new AVL();
		
		// 
		// Árvore criada no exemplo abaixo:
		//
		//  1
		//   \
		//    2
		//     \
		//      3
		//
		System.out.println("----- Inserção 1, 2, 3 ==> Rotação para Esquerda -----");
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		// 
		// Árvore rotacionada:
		//
		//    2
		//   / \
		//  1   3
		//
		avl.testRotateLeft();
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		
		avl.clear();
		
		// 
		// Árvore criada no exemplo abaixo:
		//
		//      3
		//     /
		//    2
		//   /
		//  1
		//
		System.out.println("----- Inserção 3, 2, 1 ==> Rotação para Direita -----");
		avl.insert(3);
		avl.insert(2);
		avl.insert(1);
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		// 
		// Árvore rotacionada:
		//
		//    2
		//   / \
		//  1   3
		//
		avl.testRotateRight();
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		
		avl.clear();
		
		// 
		// Árvore criada no exemplo abaixo:
		//
		//    3
		//   /
		//  1
		//   \
		//    2
		//
		System.out.println("----- Inserção 3, 1, 2 ==> Rotação Esquerda-Direita -----");
		avl.insert(3);
		avl.insert(1);
		avl.insert(2);
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		// 
		// Árvore rotacionada:
		//
		//    2
		//   / \
		//  1   3
		//
		avl.testRotateLeftRight();
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		
		avl.clear();

		// 
		// Árvore criada no exemplo abaixo:
		//
		//  1
		//   \
		//    3
		//   /
		//  2
		//
		System.out.println("----- Inserção 1, 3, 2 ==> Rotação Direita-Esquerda -----");
		avl.insert(1);
		avl.insert(3);
		avl.insert(2);
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
		// 
		// Árvore rotacionada:
		//
		//    2
		//   / \
		//  1   3
		//
		avl.testRotateRightLeft();
		System.out.println("Em ordem: \n" + avl.inReversedOrderAscii());
		System.out.println("Por nível: \n" + avl.levelOrderTraversal());
	}

}
