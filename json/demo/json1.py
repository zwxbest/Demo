import json


class GaidDevice:
    gaid = ""
    deviceId = ""
    add_time = 0
    pid = ""

    def __init__(self, a, b, c, d):
        self.gaid = a
        self.deviceId = b
        self.add_time = c
        self.pid = d


def resolveJson():
    appOpenSet = set()
    file = open(r".\app_open.json", "rb")
    fileJson = json.load(file)
    hit = fileJson["hits"]
    hits = hit["hits"]
    for h in hits:
        source = h["_source"]
        deviceId = source["device_id"]
        gaid = source["aaid"]
        p = GaidDevice(gaid, deviceId, 0, "")
        appOpenSet.add(p)

    mintegralSet = set()
    file = open(r".\mintegral.json", "rb")
    fileJson = json.load(file)
    hits = fileJson["RECORDS"]
    for h in hits:
        gaid = h["gaid"]
        mintegralSet.add(gaid)

    # 清空文件
    with open("app-min.csv", 'w') as f:
        print("")

    with open("app-min-device.csv", 'w') as f:
        print("")
    # mintegral- app_open
    for our in appOpenSet:
        found = 0
        for min in mintegralSet:
            if our.gaid == min:
                found = 1
                break
        if found == 0:
            with open("app-min.csv", 'a') as f:  # 如果filename不存在会自动创建， 'w'表示写数据，写之前会清空文件中的原有数据！
                f.write(our.gaid + "|" + our.deviceId + " |" + str(our.add_time) + " |" + our.pid + "\n")
            with open("app-min-device.csv", 'a') as f:  # 如果filename不存在会自动创建， 'w'表示写数据，写之前会清空文件中的原有数据！
                f.write("'" + our.deviceId + "'" + ",")

    with open("min-app.csv", 'w') as f:
        print("")

    for min in mintegralSet:
        found = 0
        for our in appOpenSet:
            if our.gaid == min:
                found = 1
                break
        if found == 0:
            with open("min-app.csv", 'a') as f:  # 如果filename不存在会自动创建， 'w'表示写数据，写之前会清空文件中的原有数据！
                f.write(min + "\n")

    print("1")


resolveJson()
