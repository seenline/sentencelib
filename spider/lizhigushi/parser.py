import json

f = open("result.json", "r", encoding="utf-8")
result = open("result_new.txt", "w", encoding="utf-8")
cnt = 1
p = json.loads(f.read())
for i in p.values():
    for j in i:
        result.write("标签:"+j['title']+"\n")
        for k in j['data']:
            result.write(str(cnt) + ".")
            result.write(k + "\n")
            cnt += 1
        result.write("\n")
