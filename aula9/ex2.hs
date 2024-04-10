import Data.List 
import Test.QuickCheck

data BST  = Empty
          | Node BST Int BST
              deriving Show

genBST:: Gen BST
genBST = do
  listaInts <- listOf (choose(1,1000))
  return (fromList (sort listaInts))

instance Arbitrary BST where
  arbitrary= genBSTValidOrd

prop_isValidBST :: BST -> Bool
prop_isValidBST b = isBST b

fromList :: [Int] -> BST
fromList [] = Empty
fromList (x:xs) = Node Empty x (fromList xs)

isBST :: BST -> Bool
isBST Empty = True
isBST (Node l x r) = isBST l && isBST r
                  && maybeBigger (Just x) (maybeMax l)
                  && maybeBigger (maybeMin r) (Just x)
  where maybeBigger _ Nothing = True
        maybeBigger Nothing _ = True
        maybeBigger (Just x) (Just y) = x >= y
        maybeMax Empty = Nothing
        maybeMax (Node _ x Empty) = Just x
        maybeMax (Node _ _ r) = maybeMax r
        maybeMin Empty = Nothing
        maybeMin (Node Empty x _) = Just x
        maybeMin (Node l _ _) = maybeMin l

balanced :: BST -> Bool
balanced Empty = True 
balanced (Node b1 n b2)= (abs (heightBST(b1)- heightBST(b2))< 2) && balanced b1 && balanced b2

heightBST :: BST-> Int
heightBST Empty= 0
heightBST (Node b1 n b2)= 1+ max (heightBST b1) (heightBST b2)

prop_isBalancedBST:: BST -> Bool
prop_isBalancedBST b = balanced b

fromListBalanced :: [Int] -> BST
fromListBalanced [] = Empty
fromListBalanced l =
  let size= length l
      half= div size 2
      firstHalf= take half l
      secondHalf= drop half l
      thisNode= head secondHalf
      right= tail secondHalf
  in Node (fromListBalanced firstHalf) thisNode (fromListBalanced right)
 
genBSTValidOrd:: Gen BST
genBSTValidOrd = do
  listInt<- listOf1(choose(1,1000))
  return (fromList(sort listInt))
