'''
Author: HaoTian Qi
Date: 2021-08-12 23:41:02
Description: 
LastEditTime: 2021-08-12 23:44:43
LastEditors: HaoTian Qi
'''
import requests
from htutil import file
from lxml import etree


def get_page_url():
    d_listurl_html = {}
    for i in range(1, 48):
        print(i)
        html = requests.get(
            f'http://www.lizhigushi.com/jingdiantaici/list_{i}.html')
        html.encoding = 'utf-8'
        d_listurl_html[f'http://www.lizhigushi.com/jingdiantaici/list_{i}.html'] = html.text
    # print(d_listurl_html)
    # file.write_text(f'./list/{i}.html',html.text)
    file.write_pkl('1.pkl', d_listurl_html)


def get_url():
    d_listurl_html = file.read_pkl('1.pkl')

    for k in d_listurl_html:
        s = d_listurl_html[k]
        html = etree.HTML(s)
        urls = html.xpath('/html/body/div[5]/div[1]/div[*]/dd/h3/a/@href')
        texts = html.xpath('/html/body/div[5]/div[1]/div[*]/dd/h3/a/text()')
        d_listurl_html[k] = []
        for i in range(len(urls)):
            d_listurl_html[k].append({'url': urls[i], 'title': texts[i]})
        # print(texts)
        # break
    # /html/body/div[5]/div[1]/div[2]/dd/h3/a
    # print(d_listurl_html)
    file.write_pkl('2.pkl', d_listurl_html)


def get_data():
    d = file.read_pkl('2.pkl')
    # file.write_json('d.json', d)
    # print(d)
    for k in d:
        print(k)
        for url in d[k]:
            print(url)
            r = requests.get(url['url'])
            r.encoding = 'utf-8'
            h = r.text
            h = h.replace('\r', '')
            file.write_text('1.html', h)
            html = etree.HTML(h)
            data = []
            i = 4
            while True:
                r = html.xpath(
                    f'/html/body/div[5]/div[1]/div[1]/p[{i}]/text()')
                if not r:
                    break
                r = [x[3:] for x in r]
                r = [x for x in r if len(x) > 0]
                data.extend(r)
                i += 1
            url['data'] = data
    file.write_json('result.json', d)


def main():
    get_page_url()
    get_url()
    get_data()


if __name__ == '__main__':
    main()
