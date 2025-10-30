package dev.datlag.kommons


data object VirginIslandsBritish : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("VG")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("VGB")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(92)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(1284)
}