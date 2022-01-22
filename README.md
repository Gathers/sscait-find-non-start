# sscait-find-non-start

A quick and dirty Clojure script for finding games where the replay is only available for one bot.

## Usage

Download screp.exe from https://github.com/icza/screp and place in folder *replays*.

To run from REPL:

        git clone https://github.com/Gathers/sscait-find-non-start.git
        cd sscait-find-non-start
        lein repl
        (load-file "src/sscait_find_non_start/core.clj")

The *fetch-url* function uses memoize to cache downloaded files, so you can use it multiple times from the REPL but it will only download each URL once.

## Results

This was the output when I ran it after the round-robin had ended:

        Found a total of 2916 games from 55 bots, expecting 2970 games.

        Missing both replays for 54 games:
        (37 107 133 136 233 312 435 452 511 628 729 774 796 830 895 977 1103 1155 1173 1174 1187 1276 1281 1287 1306 1381 1431 1450 1488 1527 1536 1548 1655 1663 1854 1900 2062 2064 2137 2213 2243 2245 2274 2417 2444 2578 2580 2684 2719 2721 2777 2919 2939 2970)

        Missing one replay for 502 games:
        (4 18 29 30 39 40 46 50 54 59 69 89 94 95 101 103 110 129 130 131 132 134 137 138 156 162 163 165 166 183 190 209 218 229 230 236 244 245 275 278 279 310 313 316 317 330 331 333 337 347 349 365 367 387 388 392 401 402 406 417 431 450 461 478 482 484 490 491 492 502 512 514 521 523 535 536 540 544 547 553 559 576 579 580 591 598 619 620 621 634 635 636 643 644 649 650 652 663 679 680 681 682 689 690 691 698 703 708 714 724 725 726 749 757 763 769 771 772 785 786 787 802 805 816 824 825 842 847 853 859 868 873 874 875 906 907 912 929 933 936 950 963 974 981 982 998 1001 1003 1004 1005 1013 1015 1017 1028 1033 1039 1040 1041 1043 1048 1059 1060 1071 1078 1086 1089 1090 1095 1098 1126 1132 1136 1153 1159 1170 1191 1201 1203 1209 1215 1220 1224 1229 1251 1252 1256 1272 1273 1277 1297 1302 1303 1307 1313 1319 1322 1326 1331 1334 1338 1342 1346 1348 1350 1356 1367 1375 1378 1382 1383 1385 1407 1412 1419 1423 1433 1436 1439 1455 1463 1481 1483 1491 1497 1500 1505 1509 1513 1517 1524 1531 1534 1537 1546 1553 1567 1568
        1569 1579 1592 1593 1594 1595 1597 1598 1599 1601 1606 1618 1619 1622 1624 1625 1634 1640 1656 1657 1659 1661 1664 1665 1666 1678 1683 1689 1694 1695 1697 1698 1699 1700 1707 1708 1709 1712 1720 1722 1723 1732 1733 1740 1755 1756 1760 1761 1762 1764 1766 1772 1773 1798 1800 1818 1820 1821 1822 1824 1825 1830 1832 1839 1848 1850 1853 1856 1859 1875 1883 1906 1910 1928 1931 1973 1980 1981 1983 1984 1999 2001 2005 2012 2020 2021 2026 2029 2030 2031 2033 2048 2049 2057 2065 2069 2070 2073 2095 2104 2121 2123 2125 2128 2136 2138 2140 2141 2142 2143 2151 2152 2166 2170 2189 2192 2193 2194 2195 2202 2203 2204 2207 2214 2216 2219 2221 2235 2238 2246 2247 2248 2249 2250 2252 2257 2260 2273 2280 2284 2303 2307 2311 2333 2360 2363 2370 2375 2377 2378 2380 2381 2382 2390 2393 2394 2407 2408 2411 2413 2415 2418 2425 2427 2435 2436 2437 2438 2439 2443 2449 2459 2479 2482 2483 2486 2489 2501 2507 2521 2535 2540 2547 2549 2550 2553 2565 2568 2570 2572 2573 2574 2579 2581 2604 2608 2609 2610 2611 2612 2613 2615 2624 2629 2634
        2635 2636 2638 2652 2655 2656 2661 2663 2665 2668 2669 2682 2685 2688 2689 2704 2717 2722 2726 2727 2738 2747 2748 2752 2757 2765 2766 2768 2769 2778 2783 2791 2792 2794 2808 2810 2811 2826 2827 2831 2832 2836 2851 2855 2862 2863 2864 2867 2875 2876 2877 2878 2882 2884 2904 2932 2940 2952 2959 2961)
        ("0004-Ecgb_Mega-TvP.rep" "0018-AURE_MCRA-ZVZ.REP" "0029-Kaon_Mega-TvP.rep" "0030-SIJI_WILL-ZVT.REP" "0039-FLOR_NUIB-PVZ.REP" "0040-Yuan_Siji-PvZ.rep" "0046-Hao _Jaku-TvP.rep" "0050-Bana_Stea-PvZ.rep" "0054-CUBO_Iron-ZvT.rep" "0059-SIJI_MONS-ZVZ.REP" "0069-Stea_Hao -ZvT.rep" "0089-Simp_insa-ZvT.rep" "0094-Flas_MadM-PvP.rep" "0095-ANDR_MCRA-PVZ.REP" "0101-Kaon_NuiB-TvZ.rep" "0103-Bana_Yuan-PvP.rep" "0110-Junk_insa-TvT.rep" "0129-ZurZ_Siji-ZvZ.rep" "0130-Kaso_Star-TvP.rep" "0131-Bori_Simp-ZvZ.rep" "0132-Chri_Styx-ZvZ.rep" "0134-SOER_XIAO-TVT.REP" "0137-Brya_Path-ZvZ.rep" "0138-AURE_ZURZ-ZVZ.REP" "0156-Will_Jaku-TvP.rep" "0162-TOMA_MEGA-PVP.REP" "0163-Jump_Jaku-ZvP.rep" "0165-Stea_Star-ZvP.rep" "0166-AURE_INSA-ZVT.REP" "0183-Micr_MadM-ZvP.rep" "0190-SOER_JAKU-TVP.REP" "0209-AURE_JAKU-ZVP.REP" "0218-XIAO_insa-TvT.rep" "0229-ICEL_STYX-TVZ.REP" "0230-Dave_Mega-RvP.rep" "0236-FLOR_JAKU-PVP.REP" "0244-Junk_Micr-TvZ.rep" "0245-Styx_Star-ZvP.rep" "0275-Hao _Flor-TvP.rep" "0278-ANDR_JAKU-PVP.REP" "0279-MEGA_FLAS-PVP.REP" "0310-kras_NLPR-PvZ.rep" "0313-AILi_Soer-ZvT.rep" "0316-Bori_Luka-ZvP.rep" "0317-Brya_Dave-ZvR.rep" "0330-Hao _Mons-TvZ.rep" "0331-Nite_Junk-TvT.rep" "0333-Brya_Drag-ZvT.rep" "0337-MART_FLOR-TVP.REP" "0347-NuiB_Flor-ZvP.rep" "0349-Wuli_Toma-PvP.rep" "0365-ANDR_PURP-PVP.REP" "0367-MadM_Dave-PvR.rep" "0387-Mons_Toma-ZvP.rep" "0388-Mari_Toma-TvP.rep" "0392-Mari_AILi-TvZ.rep" "0401-Prox_Flas-ZvP.rep" "0402-Iron_Beta-TvP.rep" "0406-Flas_Jaku-PvP.rep" "0417-AILi_Jaku-ZvP.rep" "0431-Beta_Jaku-PvP.rep" "0450-MATE_JAKU-TVP.REP" "0461-Flas_Jaku-PvP.rep" "0478-insa_McRa-TvZ.rep" "0482-TOMA_FLOR-PVP.REP" "0484-Star_TyrP-PvP.rep" "0490-MadM_TyrP-PvP.rep" "0491-lega_Simp-RvZ.rep" "0492-FLOR_WILL-PVT.REP" "0502-Bana_insa-PvT.rep" "0512-MEGA_NITE-PVT.REP" "0514-MATE_SOER-TVT.REP" "0521-Star_Purp-PvP.rep" "0523-XIAO_Bana-TvP.rep" "0535-NLPR_Jaku-ZvP.rep" "0536-XIAO_Mons-TvZ.rep" "0540-Mari_McRa-TvZ.rep" "0544-Prox_Jaku-ZvP.rep" "0547-Styx_Jaku-ZvP.rep" "0553-Iron_Jaku-TvP.rep" "0559-Wuli_Jaku-PvP.rep" "0576-Arra_Jaku-ZvP.rep" "0579-MEGA_TOMA-PVP.REP" "0580-Stea_insa-ZvT.rep" "0591-insa_Toma-TvP.rep" "0598-SOER_MEGA-TVP.REP" "0619-Yuan_MadM-PvP.rep" "0620-Ecgb_Arra-TvZ.rep" "0621-McRa_Flas-ZvP.rep" "0634-MATE_DAVE-TVR.REP" "0635-Nite_Jaku-TvP.rep" "0636-ICEL_MCRA-TVZ.REP" "0643-MART_JAKU-TVP.REP" "0644-Star_Jaku-PvP.rep" "0649-Mons_Jaku-ZvP.rep" "0650-Bana_Jaku-PvP.rep" "0652-Iron_Jaku-TvP.rep" "0663-Micr_Mega-ZvP.rep" "0679-MEGA_MONS-PVZ.REP" "0680-lega_Kaso-RvT.rep" "0681-Nite_Jaku-TvP.rep" "0682-CUBO_Prox-ZvZ.rep" "0689-AILi_Siji-ZvZ.rep" "0690-McRa_Drag-ZvT.rep" "0691-TOMA_JUNK-PVT.REP" "0698-Purp_Jaku-PvP.rep" "0703-SIJI_JAKU-ZVP.REP" "0708-Styx_Jaku-ZvP.rep" "0714-Brya_AILi-ZvZ.rep" "0724-NuiB_Star-ZvP.rep" "0725-Star_CUBO-PvZ.rep" "0726-TOMA_AURE-PVZ.REP" "0749-ZurZ_Jaku-ZvP.rep" "0757-NLPR_Mega-ZvP.rep" "0763-Beta_Flas-PvP.rep" "0769-TOMA_STAR-PVP.REP" "0771-Path_Toma-ZvP.rep" "0772-MATE_PURP-TVP.REP" "0785-FLOR_BETA-PVP.REP" "0786-lega_Beta-RvP.rep" "0787-insa_CUBO-TvZ.rep" "0802-McRa_AILi-ZvZ.rep" "0805-Brya_Purp-ZvP.rep" "0816-Will_AILi-TvZ.rep" "0824-TyrP_Flor-PvP.rep" "0825-Wuli_Jaku-PvP.rep" "0842-Flas_Flor-PvP.rep" "0847-Simp_Ecgb-ZvT.rep" "0853-Luka_Andr-PvP.rep" "0859-Simp_Flor-ZvP.rep" "0868-SOER_INSA-TVT.REP" "0873-ANDR_MEGA-PVP.REP" "0874-XIAO_Mega-TvP.rep" "0875-TyrP_Toma-PvP.rep" "0906-TyrP_Jaku-PvP.rep" "0907-Hao _Mega-TvP.rep" "0912-Micr_Jaku-ZvP.rep" "0929-AURE_NUIB-ZVZ.REP" "0933-kras_Yuan-PvP.rep" "0936-Bana_Micr-PvZ.rep" "0950-Kaon_TyrP-TvP.rep" "0963-Simp_insa-ZvT.rep" "0974-Chri_insa-ZvT.rep" "0981-MART_JAKU-TVP.REP" "0982-insa_Kaon-TvT.rep" "0998-McRa_insa-ZvT.rep" "1001-lega_Toma-RvP.rep" "1003-MATE_WILL-TVT.REP" "1004-Iron_Dave-TvR.rep" "1005-MATE_MONS-TVZ.REP" "1013-Bana_Drag-PvT.rep" "1015-MART_KASO-TVT.REP" "1017-AILi_Jaku-ZvP.rep" "1028-Dave_Purp-RvP.rep" "1033-Hao _Jaku-TvP.rep" "1039-Kaso_Beta-TvP.rep" "1040-MEGA_MATE-PVT.REP" "1041-Iron_McRa-TvZ.rep" "1043-Stea_Yuan-ZvP.rep" "1048-MadM_Drag-PvT.rep" "1059-Prox_insa-ZvT.rep" "1060-Kaso_Jaku-TvP.rep" "1071-XIAO_Jaku-TvP.rep" "1078-Purp_Stea-PvZ.rep" "1086-Mari_Beta-TvP.rep" "1089-Purp_Mega-PvP.rep" "1090-kras_lega-PvR.rep" "1095-kras_Siji-PvZ.rep" "1098-Drag_Mega-TvP.rep" "1126-Stea_Toma-ZvP.rep" "1132-Luka_Kaso-PvT.rep" "1136-Bana_Toma-PvP.rep" "1153-ICEL_MEGA-TVP.REP" "1159-MEGA_AILI-PVZ.REP" "1170-MEGA_SOER-PVT.REP" "1191-insa_Toma-TvP.rep" "1201-Wuli_Aure-PvZ.rep" "1203-Bori_Jaku-ZvP.rep" "1209-insa_kras-TvP.rep" "1215-AURE_PROX-ZVZ.REP" "1220-SOER_JAKU-TVP.REP" "1224-Luka_Iron-PvT.rep" "1229-ICEL_FLOR-TVP.REP" "1251-McRa_Star-ZvP.rep" "1252-Nite_Siji-TvZ.rep" "1256-MEGA_IRON-PVT.REP" "1272-Path_Yuan-ZvP.rep" "1273-Hao _Brya-TvZ.rep" "1277-AILi_Styx-ZvZ.rep" "1297-McRa_Jaku-ZvP.rep" "1302-AURE_JAKU-ZVP.REP" "1303-Kaon_Flor-TvP.rep" "1307-Mari_NuiB-TvZ.rep" "1313-ANDR_TOMA-PVP.REP" "1319-Arra_insa-ZvT.rep" "1322-insa_Jaku-TvP.rep" "1326-Styx_Toma-ZvP.rep" "1331-ANDR_INSA-PVT.REP" "1334-Luka_Jaku-PvP.rep" "1338-kras_AILi-PvZ.rep" "1342-Mons_Toma-ZvP.rep" "1346-Brya_Jaku-ZvP.rep" "1348-MEGA_XIAO-PVT.REP" "1350-Flas_Toma-PvP.rep" "1356-Brya_Toma-ZvP.rep" "1367-Junk_Bana-TvP.rep" "1375-MEGA_FLOR-PVP.REP" "1378-MEGA_IRON-PVT.REP" "1382-Prox_Yuan-ZvP.rep" "1383-AILi_ZurZ-ZvZ.rep" "1385-Bori_Yuan-ZvP.rep" "1407-Iron_Toma-TvP.rep" "1412-MEGA_HAO -PVT.REP" "1419-ZurZ_Star-ZvP.rep" "1423-Flas_Star-PvP.rep" "1433-Kaon_Mari-TvT.rep" "1436-Iron_ZurZ-TvZ.rep" "1439-MATE_KRAS-TVP.REP" "1455-Star_insa-PvT.rep" "1463-TOMA_STEA-PVZ.REP" "1481-Nite_Chri-TvZ.rep" "1483-Chri_insa-ZvT.rep" "1491-Simp_Flor-ZvP.rep" "1497-Bori_Jaku-ZvP.rep" "1500-AILi_Mega-ZvP.rep" "1505-Styx_Flor-ZvP.rep" "1509-Stea_Ecgb-ZvT.rep" "1513-ZurZ_Jaku-ZvP.rep" "1517-NLPR_insa-ZvT.rep" "1524-MEGA_KASO-PVT.REP" "1531-kras_TyrP-PvP.rep" "1534-kras_Arra-PvZ.rep" "1537-Nite_Luka-TvP.rep" "1546-lega_Mega-RvP.rep" "1553-Kaon_Junk-TvT.rep" "1567-Micr_Luka-ZvP.rep" "1568-Beta_Star-PvP.rep" "1569-Path_Jaku-ZvP.rep" "1579-Path_Mega-ZvP.rep" "1592-Nite_Toma-TvP.rep" "1593-ZurZ_Purp-ZvP.rep" "1594-Jump_Kaso-ZvT.rep" "1595-Bori_insa-ZvT.rep" "1597-Beta_Arra-PvZ.rep" "1598-Mari_NLPR-TvZ.rep" "1599-Junk_Stea-TvZ.rep" "1601-Beta_Dave-PvR.rep" "1606-MEGA_ANDR-PVP.REP" "1618-MEGA_NLPR-PVZ.REP" "1619-AILi_Jump-ZvZ.rep" "1622-Mari_Jaku-TvP.rep" "1624-Arra_NLPR-ZvZ.rep" "1625-ANDR_FLOR-PVP.REP" "1634-kras_Jaku-PvP.rep" "1640-TOMA_JAKU-PVP.REP" "1656-Star_Mons-PvZ.rep" "1657-Arra_Siji-ZvZ.rep" "1659-Jump_NLPR-ZvZ.rep" "1661-MART_PROX-TVZ.REP" "1664-McRa_Luka-ZvP.rep" "1665-Wuli_XIAO-PvT.rep" "1666-CUBO_Star-ZvP.rep" "1678-TyrP_Flor-PvP.rep" "1683-Brya_Kaso-ZvT.rep" "1689-TOMA_JAKU-PVP.REP" "1694-Luka_Jaku-PvP.rep" "1695-Mons_Jaku-ZvP.rep" "1697-TOMA_MADM-PVP.REP" "1698-TyrP_Soer-PvT.rep" "1699-Simp_Yuan-ZvP.rep" "1700-Bori_AILi-ZvZ.rep" "1707-MEGA_MADM-PVP.REP" "1708-Junk_Wuli-TvP.rep" "1709-Star_Flor-PvP.rep" "1712-TOMA_ANDR-PVP.REP" "1720-Styx_Flas-ZvP.rep" "1722-Micr_Jaku-ZvP.rep" "1723-insa_TyrP-TvP.rep" "1732-TOMA_IRON-PVT.REP" "1733-MadM_Yuan-PvP.rep" "1740-ANDR_JAKU-PVP.REP" "1755-lega_insa-RvT.rep" "1756-Luka_Dave-PvR.rep" "1760-lega_ZurZ-RvZ.rep" "1761-Stea_Junk-ZvT.rep" "1762-FLOR_HAO -PVT.REP" "1764-Iron_McRa-TvZ.rep" "1766-Hao _Mate-TvT.rep" "1772-Path_insa-ZvT.rep" "1773-ZurZ_TyrP-ZvP.rep" "1798-Drag_Jaku-TvP.rep" "1800-ZurZ_insa-ZvT.rep" "1818-kras_Jaku-PvP.rep" "1820-Styx_Nite-ZvT.rep" "1821-Yuan_Brya-PvZ.rep" "1822-MATE_BETA-TVP.REP" "1824-Stea_Kaon-ZvT.rep" "1825-Will_Toma-TvP.rep" "1830-MadM_AILi-PvZ.rep" "1832-MEGA_PROX-PVZ.REP" "1839-AURE_BANA-ZVP.REP" "1848-Wuli_Dave-PvR.rep" "1850-MATE_WULI-TVP.REP" "1853-Mons_McRa-ZvZ.rep" "1856-CUBO_McRa-ZvZ.rep" "1859-XIAO_Jaku-TvP.rep" "1875-NLPR_Jaku-ZvP.rep" "1883-Star_Toma-PvP.rep" "1906-MEGA_LUKA-PVP.REP" "1910-Simp_Jaku-ZvP.rep" "1928-Ecgb_McRa-TvZ.rep" "1931-Drag_AILi-TvZ.rep" "1973-Beta_Wuli-PvP.rep" "1980-Mons_insa-ZvT.rep" "1981-Ecgb_NuiB-TvZ.rep" "1983-Brya_XIAO-ZvT.rep" "1984-TOMA_AILI-PVZ.REP" "1999-McRa_Hao -ZvT.rep" "2001-AURE_CUBO-ZVZ.REP" "2005-SIJI_MEGA-ZVP.REP" "2012-TOMA_TOMA-PVP.REP" "2020-NLPR_Flor-ZvP.rep" "2021-Simp_Luka-ZvP.rep" "2026-Bori_Mega-ZvP.rep" "2029-Mari_Purp-TvP.rep" "2030-Star_Junk-PvT.rep" "2031-lega_Stea-RvZ.rep" "2033-Prox_Micr-ZvZ.rep" "2048-lega_Beta-RvP.rep" "2049-TyrP_Jaku-PvP.rep" "2057-Mons_insa-ZvT.rep" "2065-AURE_FLOR-ZVP.REP" "2069-Stea_insa-ZvT.rep" "2070-Bana_Jaku-PvP.rep" "2073-XIAO_McRa-TvZ.rep" "2095-Chri_Jaku-ZvP.rep" "2104-TyrP_insa-PvT.rep" "2121-Prox_Mega-ZvP.rep" "2123-ICEL_SOER-TVT.REP" "2125-Junk_Jaku-TvP.rep" "2128-CUBO_Jaku-ZvP.rep" "2136-Bana_Mega-PvP.rep" "2138-Simp_Hao -ZvT.rep" "2140-Brya_Yuan-ZvP.rep" "2141-TyrP_Junk-PvT.rep" "2142-Junk_XIAO-TvT.rep" "2143-Hao _Yuan-TvP.rep" "2151-MadM_Jaku-PvP.rep" "2152-MEGA_JAKU-PVP.REP" "2166-NuiB_Mega-ZvP.rep" "2170-Jump_kras-ZvP.rep" "2189-MEGA_BETA-PVP.REP" "2192-NuiB_Nite-ZvT.rep" "2193-ANDR_INSA-PVT.REP" "2194-Purp_Simp-PvZ.rep" "2195-Yuan_insa-PvT.rep" "2202-AILi_Luka-ZvP.rep" "2203-Kaon_Bana-TvP.rep" "2204-Brya_Jaku-ZvP.rep" "2207-Yuan_McRa-PvZ.rep" "2214-ICEL_BRYA-TVZ.REP" "2216-lega_Mega-RvP.rep" "2219-MEGA_MART-PVT.REP" "2221-Yuan_Bana-PvP.rep" "2235-MATE_MCRA-TVZ.REP" "2238-Drag_insa-TvT.rep" "2246-Kaso_Wuli-TvP.rep" "2247-Star_Hao -PvT.rep" "2248-Micr_Arra-ZvZ.rep" "2249-Star_Jaku-PvP.rep" "2250-Will_Luka-TvP.rep" "2252-TOMA_CUBO-PVZ.REP" "2257-Luka_Wuli-PvP.rep" "2260-Mons_Flor-ZvP.rep" "2273-SIJI_TYRP-ZVP.REP" "2280-Stea_Jaku-ZvP.rep" "2284-Drag_Jump-TvZ.rep" "2303-Kaon_Jaku-TvP.rep" "2307-Wuli_Toma-PvP.rep" "2311-ANDR_AILI-PVZ.REP" "2333-NuiB_Toma-ZvP.rep" "2360-MEGA_CHRI-PVZ.REP" "2363-Arra_Mega-ZvP.rep" "2370-Will_Bana-TvP.rep" "2375-Simp_Jaku-ZvP.rep" "2377-NLPR_Hao -ZvT.rep" "2378-Mari_Mate-TvT.rep" "2380-MadM_Mons-PvZ.rep" "2381-Styx_Flor-ZvP.rep" "2382-SOER_MART-TVT.REP" "2390-CUBO_Jaku-ZvP.rep" "2393-McRa_Kaon-ZvT.rep" "2394-Kaso_TyrP-TvP.rep" "2407-Micr_Mart-ZvT.rep" "2408-Junk_Purp-TvP.rep" "2411-Jump_Mega-ZvP.rep" "2413-TyrP_Toma-PvP.rep" "2415-SOER_INSA-TVT.REP" "2418-Stea_McRa-ZvZ.rep" "2425-ANDR_DRAG-PVT.REP" "2427-Nite_ZurZ-TvZ.rep" "2435-Stea_Jaku-ZvP.rep" "2436-TyrP_McRa-PvZ.rep" "2437-Path_Jaku-ZvP.rep" "2438-MadM_Bana-PvP.rep" "2439-MEGA_PURP-PVP.REP" "2443-TOMA_TOMA-PVP.REP" "2449-Drag_Will-TvT.rep" "2459-Drag_lega-TvR.rep" "2479-Drag_Flor-TvP.rep" "2482-Styx_Mari-ZvT.rep" "2483-Beta_NLPR-PvZ.rep" "2486-Hao _Toma-TvP.rep" "2489-Ecgb_Jaku-TvP.rep" "2501-MART_MCRA-TVZ.REP" "2507-insa_Mega-TvP.rep" "2521-MART_TOMA-TVP.REP" "2535-Nite_AILi-TvZ.rep" "2540-Flas_Toma-PvP.rep" "2547-FLOR_PURP-PVP.REP" "2549-ZurZ_MadM-ZvP.rep" "2550-ZurZ_Micr-ZvZ.rep" "2553-MEGA_NITE-PVT.REP" "2565-Mari_Brya-TvZ.rep" "2568-CUBO_Soer-ZvT.rep" "2570-Mons_Andr-ZvP.rep" "2572-Luka_Toma-PvP.rep" "2573-Drag_Luka-TvP.rep" "2574-TOMA_INSA-PVT.REP" "2579-McRa_Flor-ZvP.rep" "2581-FLOR_BANA-PVP.REP" "2604-ZurZ_Styx-ZvZ.rep" "2608-TyrP_Mega-PvP.rep" "2609-MEGA_YUAN-PVP.REP" "2610-MadM_Luka-PvP.rep" "2611-ZurZ_Kaso-ZvT.rep" "2612-MEGA_ZURZ-PVZ.REP" "2613-Luka_Drag-PvT.rep" "2615-MART_AILI-TVZ.REP" "2624-Kaso_McRa-TvZ.rep" "2629-Bori_Mega-ZvP.rep" "2634-Arra_TyrP-ZvP.rep" "2635-Nite_lega-TvR.rep" "2636-Will_Jaku-TvP.rep" "2638-MEGA_ZURZ-PVZ.REP" "2652-Yuan_CUBO-PvZ.rep" "2655-Flas_Arra-PvZ.rep" "2656-Ecgb_Dave-TvR.rep" "2661-Beta_Jaku-PvP.rep" "2663-Simp_Andr-ZvP.rep" "2665-AURE_TOMA-ZVP.REP" "2668-FLOR_PROX-PVZ.REP" "2669-Flas_Bana-PvP.rep" "2682-Bana_Mega-PvP.rep" "2685-Bori_NLPR-ZvZ.rep" "2688-SIJI_JAKU-ZVP.REP" "2689-Arra_Mega-ZvP.rep" "2704-Purp_Jaku-PvP.rep" "2717-ZurZ_Bori-ZvZ.rep" "2722-Stea_Arra-ZvZ.rep" "2726-ZurZ_Beta-ZvP.rep" "2727-XIAO_insa-TvT.rep" "2738-Dave_Toma-RvP.rep" "2747-lega_Jaku-RvP.rep" "2748-Dave_Purp-RvP.rep" "2752-Mons_ICEL-ZvT.rep" "2757-Wuli_AILi-PvZ.rep" "2765-MEGA_BRYA-PVZ.REP" "2766-lega_Hao -RvT.rep" "2768-AURE_MEGA-ZVP.REP" "2769-Prox_Kaso-ZvT.rep" "2778-ANDR_BANA-PVP.REP" "2783-Styx_Toma-ZvP.rep" "2791-Path_Ecgb-ZvT.rep" "2792-SIJI_NUIB-ZVZ.REP" "2794-Mons_TyrP-ZvP.rep" "2808-ICEL_JAKU-TVP.REP" "2810-MEGA_MARI-PVT.REP" "2811-SOER_TYRP-TVP.REP" "2826-insa_Jaku-TvP.rep" "2827-SIJI_TOMA-ZVP.REP" "2831-MadM_McRa-PvZ.rep" "2832-TOMA_STYX-PVZ.REP" "2836-NLPR_insa-ZvT.rep" "2851-Simp_Toma-ZvP.rep" "2855-Iron_Chri-TvZ.rep" "2862-ANDR_MCRA-PVZ.REP" "2863-Yuan_insa-PvT.rep" "2864-Wuli_Yuan-PvP.rep" "2867-TOMA_MCRA-PVZ.REP" "2875-Ecgb_XIAO-TvT.rep" "2876-Hao _Micr-TvZ.rep" "2877-McRa_Star-ZvP.rep" "2878-Yuan_Jaku-PvP.rep" "2882-MadM_XIAO-PvT.rep" "2884-Purp_McRa-PvZ.rep" "2904-ZurZ_Flor-ZvP.rep" "2932-insa_Micr-TvZ.rep" "2940-McRa_Beta-ZvP.rep" "2952-NuiB_Styx-ZvZ.rep" "2959-insa_Jump-TvZ.rep" "2961-CUBO_Mega-ZvP.rep")

        Found 271 games where at least one bot has less than 5 cmds:
        (4 29 30 33 39 40 50 59 69 94 103 129 130 132 134 137 162 165 183 229 230 234 244 245 310 313 316 317 330 331 333 365 367 400 401 402 484 490 491 492 514 521 523 536 619 620 621 629 680 682 689 690 691 724 725 726 757 763 771 772 785 786 787 788 805 847 853 874 881 907 933 936 947 950 982 1001 1003 1004 1005 1013 1015 1031 1041 1043 1048 1078 1086 1089 1090 1095 1098 1132 1201 1209 1229 1251 1252 1272 1273 1277 1303 1307 1382 1383 1385 1423 1424 1433 1436 1439 1463 1471 1481 1505 1509 1531 1537 1546 1567 1579 1592 1593 1594 1597 1598 1599 1601 1619 1624 1656 1657 1659 1660 1661 1664 1665 1666 1683 1697 1698 1699 1700 1708 1709 1712 1720 1723 1733 1756 1760 1761 1762 1764 1766 1773 1800 1821 1824 1839 1848 1850 1853 1856 1907 1983 1984 1999 2001 2005 2021 2026 2029 2030 2031 2033 2048 2121 2123 2136 2138 2141 2142 2143 2166 2170 2194 2195 2203 2214 2216 2221 2246 2247 2248 2250 2252 2257 2273 2311 2363 2370 2377 2378 2379 2380 2381 2382 2393 2394 2407 2408 2411 2418 2425 2427 2436 2438 2439 2440 2449 2459 2482
        2483 2507 2526 2547 2548 2549 2550 2565 2573 2581 2604 2608 2610 2611 2612 2613 2629 2630 2634 2635 2652 2655 2656 2669 2682 2685 2689 2722 2726 2752 2766 2768 2769 2778 2791 2794 2810 2811 2831 2855 2864 2867 2876 2877 2882 2932 2940 2952 2961)
        ("0004-Ecgb_Mega-TvP.rep" "0029-Kaon_Mega-TvP.rep" "0030-SIJI_WILL-ZVT.REP" "0033-Jump_Will-ZvT.rep" "0033-Will_Jump-TvZ.rep" "0039-FLOR_NUIB-PVZ.REP" "0040-Yuan_Siji-PvZ.rep" "0050-Bana_Stea-PvZ.rep" "0059-SIJI_MONS-ZVZ.REP" "0069-Stea_Hao -ZvT.rep" "0094-Flas_MadM-PvP.rep" "0103-Bana_Yuan-PvP.rep" "0129-ZurZ_Siji-ZvZ.rep" "0130-Kaso_Star-TvP.rep" "0132-Chri_Styx-ZvZ.rep" "0134-SOER_XIAO-TVT.REP" "0137-Brya_Path-ZvZ.rep" "0162-TOMA_MEGA-PVP.REP" "0165-Stea_Star-ZvP.rep" "0183-Micr_MadM-ZvP.rep" "0229-ICEL_STYX-TVZ.REP" "0230-Dave_Mega-RvP.rep" "0234-Arra_Mate-ZvT.rep" "0244-Junk_Micr-TvZ.rep" "0245-Styx_Star-ZvP.rep" "0310-kras_NLPR-PvZ.rep" "0313-AILi_Soer-ZvT.rep" "0316-Bori_Luka-ZvP.rep" "0317-Brya_Dave-ZvR.rep" "0330-Hao _Mons-TvZ.rep" "0331-Nite_Junk-TvT.rep" "0333-Brya_Drag-ZvT.rep" "0365-ANDR_PURP-PVP.REP" "0367-MadM_Dave-PvR.rep" "0400-Simp_Stea-ZvZ.rep" "0400-Stea_Simp-ZvZ.rep" "0401-Prox_Flas-ZvP.rep" "0402-Iron_Beta-TvP.rep" "0484-Star_TyrP-PvP.rep" "0490-MadM_TyrP-PvP.rep" "0491-lega_Simp-RvZ.rep" "0492-FLOR_WILL-PVT.REP" "0514-MATE_SOER-TVT.REP" "0521-Star_Purp-PvP.rep" "0523-XIAO_Bana-TvP.rep" "0536-XIAO_Mons-TvZ.rep" "0619-Yuan_MadM-PvP.rep" "0620-Ecgb_Arra-TvZ.rep" "0621-McRa_Flas-ZvP.rep" "0629-Path_Stea-ZvZ.rep" "0629-Stea_Path-ZvZ.rep" "0680-lega_Kaso-RvT.rep" "0682-CUBO_Prox-ZvZ.rep" "0689-AILi_Siji-ZvZ.rep" "0690-McRa_Drag-ZvT.rep" "0691-TOMA_JUNK-PVT.REP" "0724-NuiB_Star-ZvP.rep" "0725-Star_CUBO-PvZ.rep" "0726-TOMA_AURE-PVZ.REP" "0757-NLPR_Mega-ZvP.rep" "0763-Beta_Flas-PvP.rep" "0771-Path_Toma-ZvP.rep" "0772-MATE_PURP-TVP.REP" "0785-FLOR_BETA-PVP.REP" "0786-lega_Beta-RvP.rep" "0787-insa_CUBO-TvZ.rep" "0788-Purp_Beta-PvP.rep" "0805-Brya_Purp-ZvP.rep" "0847-Simp_Ecgb-ZvT.rep" "0853-Luka_Andr-PvP.rep" "0874-XIAO_Mega-TvP.rep" "0881-MEGA_SIMP-PVZ.REP" "0881-Simp_Mega-ZvP.rep" "0907-Hao _Mega-TvP.rep" "0933-kras_Yuan-PvP.rep" "0936-Bana_Micr-PvZ.rep" "0947-Stea_Flor-ZvP.rep" "0950-Kaon_TyrP-TvP.rep" "0982-insa_Kaon-TvT.rep" "1001-lega_Toma-RvP.rep" "1003-MATE_WILL-TVT.REP" "1004-Iron_Dave-TvR.rep" "1005-MATE_MONS-TVZ.REP" "1013-Bana_Drag-PvT.rep" "1015-MART_KASO-TVT.REP" "1031-Chri_Kaso-ZvT.rep" "1031-Kaso_Chri-TvZ.rep" "1041-Iron_McRa-TvZ.rep" "1043-Stea_Yuan-ZvP.rep" "1048-MadM_Drag-PvT.rep" "1078-Purp_Stea-PvZ.rep" "1086-Mari_Beta-TvP.rep" "1089-Purp_Mega-PvP.rep" "1090-kras_lega-PvR.rep" "1095-kras_Siji-PvZ.rep" "1098-Drag_Mega-TvP.rep" "1132-Luka_Kaso-PvT.rep" "1201-Wuli_Aure-PvZ.rep" "1209-insa_kras-TvP.rep" "1229-ICEL_FLOR-TVP.REP" "1251-McRa_Star-ZvP.rep" "1252-Nite_Siji-TvZ.rep" "1272-Path_Yuan-ZvP.rep" "1273-Hao _Brya-TvZ.rep" "1277-AILi_Styx-ZvZ.rep" "1303-Kaon_Flor-TvP.rep" "1307-Mari_NuiB-TvZ.rep" "1382-Prox_Yuan-ZvP.rep" "1383-AILi_ZurZ-ZvZ.rep" "1385-Bori_Yuan-ZvP.rep" "1423-Flas_Star-PvP.rep" "1424-TOMA_WULI-PVP.REP" "1433-Kaon_Mari-TvT.rep" "1436-Iron_ZurZ-TvZ.rep" "1439-MATE_KRAS-TVP.REP" "1463-TOMA_STEA-PVZ.REP" "1471-Kaon_CUBO-TvZ.rep" "1481-Nite_Chri-TvZ.rep" "1505-Styx_Flor-ZvP.rep" "1509-Stea_Ecgb-ZvT.rep" "1531-kras_TyrP-PvP.rep" "1537-Nite_Luka-TvP.rep" "1546-lega_Mega-RvP.rep" "1567-Micr_Luka-ZvP.rep" "1579-Path_Mega-ZvP.rep" "1592-Nite_Toma-TvP.rep" "1593-ZurZ_Purp-ZvP.rep" "1594-Jump_Kaso-ZvT.rep" "1597-Beta_Arra-PvZ.rep" "1598-Mari_NLPR-TvZ.rep" "1599-Junk_Stea-TvZ.rep" "1601-Beta_Dave-PvR.rep" "1619-AILi_Jump-ZvZ.rep" "1624-Arra_NLPR-ZvZ.rep" "1656-Star_Mons-PvZ.rep" "1657-Arra_Siji-ZvZ.rep" "1659-Jump_NLPR-ZvZ.rep" "1660-Will_Aure-TvZ.rep" "1661-MART_PROX-TVZ.REP" "1664-McRa_Luka-ZvP.rep" "1665-Wuli_XIAO-PvT.rep" "1666-CUBO_Star-ZvP.rep" "1683-Brya_Kaso-ZvT.rep" "1697-TOMA_MADM-PVP.REP" "1698-TyrP_Soer-PvT.rep" "1699-Simp_Yuan-ZvP.rep" "1700-Bori_AILi-ZvZ.rep" "1708-Junk_Wuli-TvP.rep" "1709-Star_Flor-PvP.rep" "1712-TOMA_ANDR-PVP.REP" "1720-Styx_Flas-ZvP.rep" "1723-insa_TyrP-TvP.rep" "1733-MadM_Yuan-PvP.rep" "1756-Luka_Dave-PvR.rep" "1760-lega_ZurZ-RvZ.rep" "1761-Stea_Junk-ZvT.rep" "1762-FLOR_HAO -PVT.REP" "1764-Iron_McRa-TvZ.rep" "1766-Hao _Mate-TvT.rep" "1773-ZurZ_TyrP-ZvP.rep" "1800-ZurZ_insa-ZvT.rep" "1821-Yuan_Brya-PvZ.rep" "1824-Stea_Kaon-ZvT.rep" "1839-AURE_BANA-ZVP.REP" "1848-Wuli_Dave-PvR.rep" "1850-MATE_WULI-TVP.REP" "1853-Mons_McRa-ZvZ.rep" "1856-CUBO_McRa-ZvZ.rep" "1907-Brya_Will-ZvT.rep" "1983-Brya_XIAO-ZvT.rep" "1984-TOMA_AILI-PVZ.REP" "1999-McRa_Hao -ZvT.rep" "2001-AURE_CUBO-ZVZ.REP" "2005-SIJI_MEGA-ZVP.REP" "2021-Simp_Luka-ZvP.rep" "2026-Bori_Mega-ZvP.rep" "2029-Mari_Purp-TvP.rep" "2030-Star_Junk-PvT.rep" "2031-lega_Stea-RvZ.rep" "2033-Prox_Micr-ZvZ.rep" "2048-lega_Beta-RvP.rep" "2121-Prox_Mega-ZvP.rep" "2123-ICEL_SOER-TVT.REP" "2136-Bana_Mega-PvP.rep" "2138-Simp_Hao -ZvT.rep" "2141-TyrP_Junk-PvT.rep" "2142-Junk_XIAO-TvT.rep" "2143-Hao _Yuan-TvP.rep" "2166-NuiB_Mega-ZvP.rep" "2170-Jump_kras-ZvP.rep" "2194-Purp_Simp-PvZ.rep" "2195-Yuan_insa-PvT.rep" "2203-Kaon_Bana-TvP.rep" "2214-ICEL_BRYA-TVZ.REP" "2216-lega_Mega-RvP.rep" "2221-Yuan_Bana-PvP.rep" "2246-Kaso_Wuli-TvP.rep" "2247-Star_Hao -PvT.rep" "2248-Micr_Arra-ZvZ.rep" "2250-Will_Luka-TvP.rep" "2252-TOMA_CUBO-PVZ.REP" "2257-Luka_Wuli-PvP.rep" "2273-SIJI_TYRP-ZVP.REP" "2311-ANDR_AILI-PVZ.REP" "2363-Arra_Mega-ZvP.rep" "2370-Will_Bana-TvP.rep" "2377-NLPR_Hao -ZvT.rep" "2378-Mari_Mate-TvT.rep" "2379-TOMA_FLAS-PVP.REP" "2380-MadM_Mons-PvZ.rep" "2381-Styx_Flor-ZvP.rep" "2382-SOER_MART-TVT.REP" "2393-McRa_Kaon-ZvT.rep" "2394-Kaso_TyrP-TvP.rep" "2407-Micr_Mart-ZvT.rep" "2408-Junk_Purp-TvP.rep" "2411-Jump_Mega-ZvP.rep" "2418-Stea_McRa-ZvZ.rep" "2425-ANDR_DRAG-PVT.REP" "2427-Nite_ZurZ-TvZ.rep" "2436-TyrP_McRa-PvZ.rep" "2438-MadM_Bana-PvP.rep" "2439-MEGA_PURP-PVP.REP" "2440-Chri_Stea-ZvZ.rep" "2440-Stea_Chri-ZvZ.rep" "2449-Drag_Will-TvT.rep" "2459-Drag_lega-TvR.rep" "2482-Styx_Mari-ZvT.rep" "2483-Beta_NLPR-PvZ.rep" "2507-insa_Mega-TvP.rep" "2526-Junk_Path-TvZ.rep" "2526-Path_Junk-ZvT.rep" "2547-FLOR_PURP-PVP.REP" "2548-Dave_Kaon-RvT.rep" "2548-Kaon_Dave-TvR.rep" "2549-ZurZ_MadM-ZvP.rep" "2550-ZurZ_Micr-ZvZ.rep" "2565-Mari_Brya-TvZ.rep" "2573-Drag_Luka-TvP.rep" "2581-FLOR_BANA-PVP.REP" "2604-ZurZ_Styx-ZvZ.rep" "2608-TyrP_Mega-PvP.rep" "2610-MadM_Luka-PvP.rep" "2611-ZurZ_Kaso-ZvT.rep" "2612-MEGA_ZURZ-PVZ.REP" "2613-Luka_Drag-PvT.rep" "2629-Bori_Mega-ZvP.rep" "2630-Jump_MadM-ZvP.rep" "2630-MadM_Jump-PvZ.rep" "2634-Arra_TyrP-ZvP.rep" "2635-Nite_lega-TvR.rep" "2652-Yuan_CUBO-PvZ.rep" "2655-Flas_Arra-PvZ.rep" "2656-Ecgb_Dave-TvR.rep" "2669-Flas_Bana-PvP.rep" "2682-Bana_Mega-PvP.rep" "2685-Bori_NLPR-ZvZ.rep" "2689-Arra_Mega-ZvP.rep" "2722-Stea_Arra-ZvZ.rep" "2726-ZurZ_Beta-ZvP.rep" "2752-Mons_ICEL-ZvT.rep" "2766-lega_Hao -RvT.rep" "2768-AURE_MEGA-ZVP.REP" "2769-Prox_Kaso-ZvT.rep" "2778-ANDR_BANA-PVP.REP" "2791-Path_Ecgb-ZvT.rep" "2794-Mons_TyrP-ZvP.rep" "2810-MEGA_MARI-PVT.REP" "2811-SOER_TYRP-TVP.REP" "2831-MadM_McRa-PvZ.rep" "2855-Iron_Chri-TvZ.rep" "2864-Wuli_Yuan-PvP.rep" "2867-TOMA_MCRA-PVZ.REP" "2876-Hao _Micr-TvZ.rep" "2877-McRa_Star-ZvP.rep" "2882-MadM_XIAO-PvT.rep" "2932-insa_Micr-TvZ.rep" "2940-McRa_Beta-ZvP.rep" "2952-NuiB_Styx-ZvZ.rep" "2961-CUBO_Mega-ZvP.rep")

        Number of times each bot was in a game where any bot has a missing replay:
        ([JAKU 84] [MEGA 60] [TOMA 52] [INSA 44] [MCRA 33] [FLOR 30] [AILI 23] [TYRP 22] [STAR 22] [ZURZ 21] [YUAN 21] [BANA 20] [LUKA 19] [BETA 18] [ANDR 18] [STEA 18] [MONS 18] [HAO  18] [MADM 17] [PURP 17] [STYX 16] [BRYA 16] [XIAO 15] [SIMP 15] [DRAG 15] [LEGA 15] [SIJI 14] [IRON 14] [NLPR 14] [FLAS 14] [WULI 14] [AURE 14] [KASO 14] [NITE 14] [SOER 14] [JUNK 14] [MATE 13] [ARRA 13] [MARI 13] [MICR 13] [CUBO 13] [KRAS 12] [DAVE 12] [PROX 12] [NUIB 12] [BORI 11] [MART 11] [KAON 11] [WILL 10] [ECGB 10] [ICEL 8] [JUMP 8] [PATH 8] [CHRI 7])

        Number of times each bot was in a replay where any bot had less than 5 cmds:
        ([MEGA 31] [STEA 20] [MADM 16] [MCRA 16] [YUAN 16] [TYRP 15] [STAR 15] [BANA 15] [TOMA 14] [ZURZ 14] [PURP 13] [LUKA 13] [HAO  13] [LEGA 13] [BETA 12] [FLOR 12] [KASO 12] [JUNK 12] [ARRA 11] [KAON 11] [BRYA 11] [SIJI 10] [WILL 10] [DAVE 10] [STYX 10] [SIMP 10] [DRAG 10] [MICR 10] [CUBO 10] [MATE 9] [MONS 9] [MARI 9] [FLAS 9] [JUMP 9] [PATH 9] [WULI 9] [NLPR 8] [XIAO 8] [KRAS 8] [INSA 8] [AILI 8] [PROX 7] [CHRI 7] [NITE 7] [SOER 7] [IRON 6] [ANDR 6] [BORI 6] [ECGB 6] [AURE 6] [ICEL 5] [NUIB 5] [MART 4])

        Frequency of min(cmds) in all replays ([min(cmds) occurances]):
        ([1 252] [0 19] [376 6] [3 5] [11 5] [2 4] [5 4] [480 4])

It seems like *Jakub Trancik* ends most games in a crash and should be regarded as a false positive.

I have a hunch most games that show the message `No activity detected for the first in-game minute, exiting` end with 1 cmd for that bot, and that games that show a message like `BWAPI 4.4.0.5016 RELEASE is now live using "Nothing".` end with 0 cmds for that bot.

## License

The Unlicense, do whatever.
