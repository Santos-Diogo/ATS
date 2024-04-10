import Test.QuickCheck

mulL :: Num a => [a] -> a
mulL [] = 0
mulL (h : t) = h * mulL t

prop_mulRev :: [Int] -> Bool
prop_mulRev xs = mulL (reverse xs) == mulL xs
