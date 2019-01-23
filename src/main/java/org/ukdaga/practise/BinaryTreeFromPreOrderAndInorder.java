/*******************************************************************************
* Copyright (c) 2019, MasterCard International Incorporated and/or its
* affiliates. All rights reserved.
*
* TO THE EXTENT PERMITTED BY LAW, THE SOFTWARE IS PROVIDED "AS IS", WITHOUT 
* WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
* WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND 
* NON INFRINGEMENT. TO THE EXTENT PERMITTED BY LAW, IN NO EVENT SHALL
* MASTERCARD OR ITS AFFILIATES BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING 
* FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS 
* IN THE SOFTWARE.
******************************************************************************/
package org.ukdaga.practise;

public class BinaryTreeFromPreOrderAndInorder {

	int preIndex;

	public BinaryTreeFromPreOrderAndInorder()
	{
		preIndex = 0;
	}

	public Node constructTree (char []inOrder , char []preOrder , int searchStart, int searchEnd)
	{

		if(searchStart>searchEnd)
			return null;

		Node node = new Node (preOrder[preIndex++]); // LST and RST initialized to null

		if(searchStart==searchEnd)
			return node;

		int inIndex = search (node.data , inOrder, searchStart, searchEnd);


		node.left = constructTree (inOrder , preOrder, searchStart , inIndex - 1);
		node.right= constructTree (inOrder , preOrder, inIndex+1 , searchEnd);

		return node;

	}

	private int search(char c, char[] inOrder, int searchStart, int searchEnd) {
		for (int i = searchStart ; i<=searchEnd ; i++ )
		{
			if(inOrder[i]==c)
				return i;
		}
		return -1;
	}


	public static void main(String args[])
	{
		char inOrder[] = { 'e','d','b','f','a','g','i','c','h'};
		char preOrder[] = {'a','b','d','e','f','c','g','i','h'};  
		BinaryTreeFromPreOrderAndInorder tree = new BinaryTreeFromPreOrderAndInorder();
		Node root=tree.constructTree (inOrder , preOrder, 0 , 9-1);
		printInorder(root);
	}


	private static void printInorder(Node node) {
		if (node == null) 
			return; 
		printInorder(node.left); 
		System.out.print(node.data + " "); 
		printInorder(node.right); 
	}
}
class Node
{
	public Node left;
	public Node right;
	public char data;
	
	public Node (char data)
	{
		this.data = data;
		left = null;
		right = null;
	}
}

