with open("family.in", "r") as f:
    n, a, b = f.readline().split()

    motherOf = {}
    for l in f.readlines():
        l = l.split()
        motherOf[l[1]] = l[0]


def LCA(A, B):
    def AncestorList(curr):
        ancestors = []
        while True:
            ancestors.append(curr)
            if curr in motherOf:
                curr = motherOf[curr]
            else:
                break
        return ancestors

    aAcenstors = AncestorList(A)
    bAcenstors = AncestorList(B)

    for i in aAcenstors:
        for j in bAcenstors:
            if i == j:
                return i, aAcenstors.index(i), bAcenstors.index(j)

    return None


def solve(ancestor, distanceA, distanceB):
    swapped = False
    if distanceA > distanceB:
        distanceA, distanceB = distanceB, distanceA
        swapped = True
    output = ""

    if distanceA == 1:
        if distanceB == 1:
            output += "SIBLINGS"
        else:
            output += "great-" * (distanceB - 2) + "aunt"
    elif distanceA > 1:
        output += "COUSINS"
    else:
        if distanceB >= 2:
            output += "great-" * (distanceB - 2) + "grand-mother"
        elif distanceB == 1:
            output += "mother"

    return output, swapped


try:
    output, swapped = solve(*LCA(a, b))  # type: ignore
    if output == "SIBLINGS" or output == "COUSINS":
        with open("family.out", "w") as f:
            f.write(output + "\n")
    else:
        with open("family.out", "w") as f:
            f.write(
                f"{a if not swapped else b} is the {output} of {b if not swapped else a}\n"
            )

except:
    with open("family.out", "w") as f:
        f.write("NOT RELATED\n")
