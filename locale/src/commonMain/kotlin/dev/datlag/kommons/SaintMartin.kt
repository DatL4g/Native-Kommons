package dev.datlag.kommons


data object SaintMartin : Country {
    override val codeAlpha2: Country.Code.Alpha2 = Country.Code.Alpha2("MF")
    override val codeAlpha3: Country.Code.Alpha3 = Country.Code.Alpha3("MAF")
    override val codeNumeric: Country.Code.Numeric = Country.Code.Numeric(663)
    override val telephoneCodes: Set<Country.Code.Telephone> = Country.Code.Telephone.setFrom(590)
}