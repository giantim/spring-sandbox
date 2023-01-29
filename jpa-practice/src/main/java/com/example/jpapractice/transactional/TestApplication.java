package com.example.jpapractice.transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestApplication {

    public static void main(String[] args) throws Exception {
        String afterProperties = "woowahan:\n" +
                "  router:\n" +
                "    region:\n" +
                "      exclude:\n" +
                "        regions: \n" +
                "          - code: 88\n" +
                "            name: 우아한형제도\n" +
                "          - code: 88888\n" +
                "            name: 우형시\n" +
                "          - code: 88888888\n" +
                "            name: 우형동\n" +
                "          - code: 98\n" +
                "            name: USA\n" +
                "          - code: 98999\n" +
                "            name: NewYork\n" +
                "          - code: 98999999\n" +
                "            name: Manhattan Center\n" +
                "          - code: 99\n" +
                "            name: 딜리버리왕국\n" +
                "          - code: 99999\n" +
                "            name: 딜리버리시티\n" +
                "          - code: 99999999\n" +
                "            name: 딜리동\n" +
                "  order:\n" +
                "    bulkCancel:\n" +
                "      rowCountPerBatchUpdate: 499\n" +
                "      breakMilliSeconds: 100\n" +
                "      baeminOneOrderCountPerRequest: 5000\n" +
                "    orderServer: ot-gateway-order\n" +
                "\n" +
                "vdi:\n" +
                "  whitelist:\n" +
                "    pathPatterns:\n" +
                "      - /v1/api/delivery-histories/excel-download # 배달내역 정산 엑셀다운로드\n" +
                "    subnets:\n" +
                "      - 172.17.0.0/16 # 작은집\n" +
                "      - 172.18.0.0/16 # 큰집\n" +
                "      - 172.27.0.0/16 # 신규 VPN\n";
        String beforeProperties = "woowahan:\n" +
                "  router:\n" +
                "    region:\n" +
                "      exclude:\n" +
                "        regions: \n" +
                "          - code: 88\n" +
                "            name: 우아한형제도\n" +
                "          - code: 88888\n" +
                "            name: 우형시\n" +
                "          - code: 88888888\n" +
                "            name: 우형동\n" +
                "          - code: 98\n" +
                "            name: USA\n" +
                "          - code: 98999\n" +
                "            name: NewYork\n" +
                "          - code: 98999999\n" +
                "            name: Manhattan Center\n" +
                "          - code: 99\n" +
                "            name: 딜리버리왕국\n" +
                "          - code: 99999\n" +
                "            name: 딜리버리시티\n" +
                "          - code: 99999999\n" +
                "            name: 딜리동\n" +
                "  order:\n" +
                "    bulkCancel:\n" +
                "      rowCountPerBatchUpdate: 499\n" +
                "      breakMilliSeconds: 100\n" +
                "      baeminOneOrderCountPerRequest: 5000\n" +
                "    orderServer: ot-gateway-order\n" +
                "\n" +
                "vdi:\n" +
                "  whitelist:\n" +
                "    pathPatterns:\n" +
                "      - /v1/api/delivery-histories/excel-download # 배달내역 정산 엑셀다운로드\n" +
                "    subnets:\n" +
                "      - 172.17.0.0/16 # 작은집\n" +
                "      - 172.18.0.0/16 # 큰집\n" +
                "      - 172.27.0.0/16 # 신규 VPN\n";

        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        objectMapper.findAndRegisterModules();
        LinkedHashMap<Object, Object> before = objectMapper.readValue(beforeProperties, LinkedHashMap.class);
        LinkedHashMap<Object, Object> after = objectMapper.readValue(afterProperties, LinkedHashMap.class);

        List<YamlNode> afterNodes = new ArrayList<>();
        for (Map.Entry<Object, Object> entry : after.entrySet()) {

        }

        System.out.println("hi");
    }

    private static void setUp(Set<Map.Entry<Object, Object>> entrySet, List<YamlNode> yamlNodes, int depth, String parentKey) {
        for (Map.Entry<Object, Object> entry : entrySet) {
            if (entry.getKey() instanceof String && entry.getValue() instanceof LinkedHashMap) {
                yamlNodes.add(new YamlNode((String) entry.getKey(), Collections.emptyList(), depth, parentKey));
                setUp(((LinkedHashMap<Object, Object>) entry.getValue()).entrySet(), yamlNodes, depth + 1, (String) entry.getKey());
            } else {

            }
        }
    }

    @Getter
    public static class YamlNode {

        private String key;
        private List<YamlValue> values;
        private int depth;
        private String parentKey;

        public YamlNode(String key, List<YamlValue> values, int depth, String parentKey) {
            this.key = key;
            this.values = values;
            this.depth = depth;
            this.parentKey = parentKey;
        }
    }

    @Getter
    public static class YamlValue<T> {

        private T value;

        public YamlValue(T value) {
            this.value = value;
        }
    }
}
