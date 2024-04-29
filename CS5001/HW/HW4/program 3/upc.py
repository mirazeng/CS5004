def is_valid_upc(list_of_integers: list) -> bool:
    list_of_integers.reverse()
    if len(list_of_integers) < 2:
        return False
    else:
        if list_of_integers.count(0) == len(list_of_integers):
            return False
        tracker = 0
        sum_total = 0
        for x in list_of_integers:
            # 在loop中tracker会跟着loop更新，且老结果不会被记录
            even_num = 0
            odd_num = 0
            if tracker % 2 != 0:
                even_num = x * 3
            else:
                odd_num = x
            each_sum = even_num + odd_num
            sum_total += each_sum
            tracker += 1
        if sum_total % 10 == 0:
            return True
        else:
            return False


print(is_valid_upc([0, 7, 3, 8, 5, 4, 0, 0, 8, 0, 8, 9]))
