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
  arbitrary= genBST

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
